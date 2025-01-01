package com.tistory.jaimemin.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.application.port.in.IncreaseMoneyRequestCommand;
import com.tistory.jaimemin.application.port.in.IncreaseMoneyRequestUseCase;
import com.tistory.jaimemin.common.WebAdapter;
import com.tistory.jaimemin.domain.MoneyChangingRequest;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/money")
public class RequestMoneyChangingController {

	private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

	// private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

	@PostMapping(path = "/increase")
	MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
		IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
			.targetMembershipId(request.getTargetMembershipId())
			.amount(request.getAmount())
			.build();
		MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);
		MoneyChangingResultDetail resultDetail = new MoneyChangingResultDetail(
			moneyChangingRequest.getMoneyChangingRequestId()
			, 0
			, 0
			, moneyChangingRequest.getChangingMoneyAmount());

		return resultDetail;
	}

	@PostMapping(path = "/decrease")
	MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
		// RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
		// 	.membershipId(request.getMembershipId())
		// 	.bankName(request.getBankName())
		// 	.bankAccountNumber(request.getBankAccountNumber())
		// 	.isValid(request.isValid())
		// 	.build();

		// registeredBankAccountUseCase.registerBankAccount(command)
		// -> MoneyChangingResultDetail
		// return decreaseMoneyRequestUseCase.decreaseMoneyChangingRequest(command);
		return null;
	}
}
