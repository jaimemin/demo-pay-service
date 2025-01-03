package com.tistory.jaimemin.application.port.out;

import com.tistory.jaimemin.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.tistory.jaimemin.domain.FirmbankingRequest;

public interface RequestFirmbankingPort {

	FirmbankingRequestJpaEntity createFirmbankingRequest(
		FirmbankingRequest.FromBankName fromBankName,
		FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
		FirmbankingRequest.ToBankName toBankName,
		FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
		FirmbankingRequest.MoneyAmount moneyAmount,
		FirmbankingRequest.FirmbankingStatus firmbankingStatus
	);

	FirmbankingRequestJpaEntity modifyFirmbankingRequest(
		FirmbankingRequestJpaEntity entity
	);
}
