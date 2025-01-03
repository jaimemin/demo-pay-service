package com.tistory.jaimemin.adapter.out.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.tistory.jaimemin.application.port.out.IncreaseMoneyPort;
import com.tistory.jaimemin.common.PersistenceAdapter;
import com.tistory.jaimemin.domain.MemberMoney;
import com.tistory.jaimemin.domain.MoneyChangingRequest;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

	private final SpringDataMemberMoneyRepository memberMoneyRepository;

	private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

	@Override
	public MoneyChangingRequestJpaEntity createMoneyChangingRequest(
		MoneyChangingRequest.TargetMembershipId targetMembershipId
		, MoneyChangingRequest.MoneyChangingType moneyChangingType
		, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount
		, MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus
		, MoneyChangingRequest.Uuid uuid) {
		return moneyChangingRequestRepository.save(
			new MoneyChangingRequestJpaEntity(
				targetMembershipId.getTargetMembershipId(),
				moneyChangingType.getMoneyChangingType(),
				changingMoneyAmount.getChangingMoneyAmount(),
				new Timestamp(System.currentTimeMillis()), // TODO: yyyy-MM-dd hh:mm:ss
				moneyChangingStatus.getChangingMoneyStatus(),
				UUID.randomUUID()
			)
		);
	}

	@Override
	public MemberMoneyJpaEntity increaseMoney(MemberMoney.MembershipId memberId, int increaseMoneyAmount) {
		MemberMoneyJpaEntity entity;

		try {
			List<MemberMoneyJpaEntity> entityList
				= memberMoneyRepository.findByMembershipId(Long.parseLong(memberId.getMembershipId()));
			entity = entityList.get(0);
			entity.setBalance(entity.getBalance() + increaseMoneyAmount);

			return memberMoneyRepository.save(entity);
		} catch (Exception e) {
			entity = new MemberMoneyJpaEntity(
				Long.parseLong(memberId.getMembershipId()),
				increaseMoneyAmount
			);
			entity = memberMoneyRepository.save(entity);

			return entity;
		}
	}
}