package com.tistory.jaimemin.membershipservice.application.port.in;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.tistory.jaimemin.common.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

	@NotNull
	private final String name;

	@NotNull
	private final String email;

	@NotNull
	private final String address;

	@AssertTrue
	private final boolean isValid;

	private final boolean isCorp;

	@Builder
	public RegisterMembershipCommand(boolean isCorp, boolean isValid, String address, String email, String name) {
		this.isCorp = isCorp;
		this.isValid = isValid;
		this.address = address;
		this.email = email;
		this.name = name;

		this.validateSelf();
	}
}
