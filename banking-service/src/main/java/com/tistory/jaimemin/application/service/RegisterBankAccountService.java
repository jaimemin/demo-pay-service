package com.tistory.jaimemin.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.tistory.jaimemin.adapter.out.external.bank.BankAccount;
import com.tistory.jaimemin.adapter.out.external.bank.GetBankAccountRequest;
import com.tistory.jaimemin.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.tistory.jaimemin.adapter.out.persistence.RegisteredBankAccountMapper;
import com.tistory.jaimemin.application.port.in.RegisterBankAccountCommand;
import com.tistory.jaimemin.application.port.in.RegisterBankAccountUseCase;
import com.tistory.jaimemin.application.port.out.RegisterBankAccountPort;
import com.tistory.jaimemin.application.port.out.RequestBankAccountInfoPort;
import com.tistory.jaimemin.common.UseCase;
import com.tistory.jaimemin.domain.RegisteredBankAccount;

import lombok.RequiredArgsConstructor;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

	private final RegisteredBankAccountMapper mapper;

	private final RegisterBankAccountPort registerBankAccountPort;

	private final RequestBankAccountInfoPort requestBankAccountInfoPort;

	@Override
	public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {
		// 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
		// Biz Logic -> External System
		// Port -> Adapter -> External System
		// 실제 외부의 은행계좌 정보를 Get
		BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(
			new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
		boolean accountIsValid = accountInfo.isValid();

		// 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
		// 2-1. 등록가능하지 않은 계좌라면. 에러를 리턴
		if (accountIsValid) {
			RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
				new RegisteredBankAccount.MembershipId(command.getMembershipId() + ""),
				new RegisteredBankAccount.BankName(command.getBankName()),
				new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
				new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
			);

			return mapper.mapToDomainEntity(savedAccountInfo);
		}

		return null;
	}
}
