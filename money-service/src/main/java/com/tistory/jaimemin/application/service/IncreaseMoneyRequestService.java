package com.tistory.jaimemin.application.service;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.tistory.jaimemin.adapter.out.persistence.MemberMoneyJpaEntity;
import com.tistory.jaimemin.adapter.out.persistence.MoneyChangingRequestMapper;
import com.tistory.jaimemin.application.port.in.IncreaseMoneyRequestCommand;
import com.tistory.jaimemin.application.port.in.IncreaseMoneyRequestUseCase;
import com.tistory.jaimemin.application.port.out.IncreaseMoneyPort;
import com.tistory.jaimemin.common.UseCase;
import com.tistory.jaimemin.domain.MemberMoney;
import com.tistory.jaimemin.domain.MoneyChangingRequest;

import lombok.RequiredArgsConstructor;

@UseCase
@Transactional
@RequiredArgsConstructor
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

	private final MoneyChangingRequestMapper mapper;

	private final IncreaseMoneyPort increaseMoneyPort;

	/**
	 * 1. 고객 정보가 정상인지 확인 (멤버)
	 * 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)
	 * 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)
	 * 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)
	 * 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (뱅킹)
	 * 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
	 * 성공 시 멤버의 MemberMoney 값 증액 필요
	 * 실패 시 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴
	 */
	@Override
	public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {
		MemberMoneyJpaEntity memberMoneyJpaEntity = increaseMoneyPort.increaseMoney(
			new MemberMoney.MembershipId(command.getTargetMembershipId())
			, command.getAmount());

		if (memberMoneyJpaEntity != null) {
			return mapper.mapToDomainEntity(increaseMoneyPort.createMoneyChangingRequest(
					new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
					new MoneyChangingRequest.MoneyChangingType(1),
					new MoneyChangingRequest.ChangingMoneyAmount(command.getAmount()),
					new MoneyChangingRequest.MoneyChangingStatus(1),
					new MoneyChangingRequest.Uuid(UUID.randomUUID().toString())
				)
			);
		}

		// memberMoneyJpaEntity.setBalance(memberMoneyJpaEntity.getBalance() + command.getAmount());

		return null;
	}
}
