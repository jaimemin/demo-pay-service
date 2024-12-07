package com.tistory.jaimemin.application.port.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tistory.jaimemin.common.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

	@NotNull
	private final String membershipId;

	@NotNull
	private final String bankName;

	@NotNull
	@NotBlank
	private final String bankAccountNumber;

	private final boolean isValid;

	public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber, boolean isValid) {
		this.membershipId = membershipId;
		this.bankName = bankName;
		this.bankAccountNumber = bankAccountNumber;
		this.isValid = isValid;

		this.validateSelf();
	}
}