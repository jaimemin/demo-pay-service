package com.tistory.jaimemin.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.domain.MoneyChangingRequest;

@Component
public class MoneyChangingRequestMapper {

	public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
		return MoneyChangingRequest.generateMoneyChangingRequest(
			new MoneyChangingRequest.MoneyChangingRequestId(
				moneyChangingRequestJpaEntity.getMoneyChangingRequestId() + "")
			, new MoneyChangingRequest.TargetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId())
			, new MoneyChangingRequest.MoneyChangingType(moneyChangingRequestJpaEntity.getMoneyChangingType())
			, new MoneyChangingRequest.ChangingMoneyAmount(moneyChangingRequestJpaEntity.getMoneyAmount())
			, new MoneyChangingRequest.MoneyChangingStatus(moneyChangingRequestJpaEntity.getChangingMoneyStatus())
			, moneyChangingRequestJpaEntity.getUuid()
		);
	}
}
