package com.tistory.jaimemin.adapter.out.external.bank;

import com.tistory.jaimemin.application.port.out.RequestBankAccountInfoPort;
import com.tistory.jaimemin.common.ExternalSystemAdapter;

import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

	@Override
	public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
		// TODO: 실제로 외부 은행에 http 을 통해서 실제 은행 계좌 정보를 가져오고
		// TODO: BankAccount 객체로 반환
		return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
	}
}
