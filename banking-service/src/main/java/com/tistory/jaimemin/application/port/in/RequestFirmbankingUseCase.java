package com.tistory.jaimemin.application.port.in;

import com.tistory.jaimemin.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {

	FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
