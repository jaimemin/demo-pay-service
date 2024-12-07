package com.tistory.jaimemin.adapter.out.persistence;

import java.util.UUID;

import com.tistory.jaimemin.application.port.out.RequestFirmbankingPort;
import com.tistory.jaimemin.common.PersistenceAdapter;
import com.tistory.jaimemin.domain.FirmbankingRequest;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

	private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;

	@Override
	public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName
		, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber
		, FirmbankingRequest.ToBankName toBankName
		, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber
		, FirmbankingRequest.MoneyAmount moneyAmount
		, FirmbankingRequest.FirmbankingStatus firmbankingStatus) {
		return firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
				fromBankName.getFromBankName(),
				fromBankAccountNumber.getFromBankAccountNumber(),
				toBankName.getToBankName(),
				toBankAccountNumber.getToBankAccountNumber(),
				moneyAmount.getMoneyAmount(), firmbankingStatus.getFirmBankingStatus(),
				UUID.randomUUID()
			)
		);
	}

	@Override
	public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
		return firmbankingRequestRepository.save(entity);
	}
}
