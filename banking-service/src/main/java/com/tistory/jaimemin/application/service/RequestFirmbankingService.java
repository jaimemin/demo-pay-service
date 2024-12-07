package com.tistory.jaimemin.application.service;

import java.util.UUID;

import javax.transaction.Transactional;

import com.tistory.jaimemin.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.tistory.jaimemin.adapter.out.external.bank.FirmbankingResult;
import com.tistory.jaimemin.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.tistory.jaimemin.adapter.out.persistence.FirmbankingRequestMapper;
import com.tistory.jaimemin.application.port.in.RequestFirmbankingCommand;
import com.tistory.jaimemin.application.port.in.RequestFirmbankingUseCase;
import com.tistory.jaimemin.application.port.out.RequestExternalFirmbankingPort;
import com.tistory.jaimemin.application.port.out.RequestFirmbankingPort;
import com.tistory.jaimemin.common.UseCase;
import com.tistory.jaimemin.domain.FirmbankingRequest;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

	private final FirmbankingRequestMapper mapper;

	private final RequestFirmbankingPort requestFirmbankingPort;

	private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

	/**
	 * Business Logic
	 *
	 * a -> b 계좌
	 */
	@Override
	public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {
		// 1. 요청에 대해 정보를 먼저 write . "요청" 상태로
		FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
			new FirmbankingRequest.FromBankName(command.getFromBankName()),
			new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
			new FirmbankingRequest.ToBankName(command.getToBankName()),
			new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
			new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
			new FirmbankingRequest.FirmbankingStatus(0)
		);

		// 2. 외부 은행에 펌뱅킹 요청
		FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(
			new ExternalFirmbankingRequest(
				command.getFromBankName(),
				command.getFromBankAccountNumber(),
				command.getToBankName(),
				command.getToBankAccountNumber()
			));

		UUID randomUUID = UUID.randomUUID();
		requestedEntity.setUuid(randomUUID.toString());

		// 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 Update
		requestedEntity.setFirmbankingStatus(result.getResultCode() == 0 ? 1 : 2);

		// 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
		return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
	}
}
