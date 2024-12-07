package com.tistory.jaimemin.application.port.out;

import com.tistory.jaimemin.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.tistory.jaimemin.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {

	FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
