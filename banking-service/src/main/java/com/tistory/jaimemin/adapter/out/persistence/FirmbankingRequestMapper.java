package com.tistory.jaimemin.adapter.out.persistence;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.domain.FirmbankingRequest;

@Component
public class FirmbankingRequestMapper {

	public FirmbankingRequest mapToDomainEntity(FirmbankingRequestJpaEntity registeredBankAccountJpaEntity, UUID uuid) {
		return FirmbankingRequest.generateFirmbankingRequest(
			new FirmbankingRequest.FirmbankingRequestId(registeredBankAccountJpaEntity.getRequestFirmbankingId() + ""),
			new FirmbankingRequest.FromBankName(registeredBankAccountJpaEntity.getFromBankName()),
			new FirmbankingRequest.FromBankAccountNumber(registeredBankAccountJpaEntity.getFromBankAccountNumber()),
			new FirmbankingRequest.ToBankName(registeredBankAccountJpaEntity.getToBankName()),
			new FirmbankingRequest.ToBankAccountNumber(registeredBankAccountJpaEntity.getToBankAccountNumber()),
			new FirmbankingRequest.MoneyAmount(registeredBankAccountJpaEntity.getMoneyAmount()),
			new FirmbankingRequest.FirmbankingStatus(registeredBankAccountJpaEntity.getFirmbankingStatus()),
			uuid
		);
	}
}
