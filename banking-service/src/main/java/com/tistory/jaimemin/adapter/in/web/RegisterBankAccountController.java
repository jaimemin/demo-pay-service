package com.tistory.jaimemin.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.application.port.in.RegisterBankAccountCommand;
import com.tistory.jaimemin.application.port.in.RegisterBankAccountUseCase;
import com.tistory.jaimemin.common.WebAdapter;
import com.tistory.jaimemin.domain.RegisteredBankAccount;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

	private final RegisterBankAccountUseCase registeredBankAccountUseCase;

	@PostMapping(path = "/banking/account/register")
	RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
		RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
			.membershipId(request.getMembershipId())
			.bankName(request.getBankName())
			.bankAccountNumber(request.getBankAccountNumber())
			.isValid(request.isValid())
			.build();

		return registeredBankAccountUseCase.registerBankAccount(command);
	}
}
