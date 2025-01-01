package com.tistory.jaimemin.application.port.out;

import com.tistory.jaimemin.adapter.out.persistence.MemberMoneyJpaEntity;
import com.tistory.jaimemin.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.tistory.jaimemin.domain.MemberMoney;
import com.tistory.jaimemin.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

	MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest.TargetMembershipId targetMembershipId
		, MoneyChangingRequest.MoneyChangingType moneyChangingType
		, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount
		, MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus
		, MoneyChangingRequest.Uuid uuid
	);

	MemberMoneyJpaEntity increaseMoney(MemberMoney.MembershipId memberId, int increaseMoneyAmount);
}
