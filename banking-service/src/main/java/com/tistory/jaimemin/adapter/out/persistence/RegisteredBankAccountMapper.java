package com.tistory.jaimemin.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.domain.RegisteredBankAccount;

@Component
public class RegisteredBankAccountMapper {

	public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
		return RegisteredBankAccount.generateRegisteredBankAccount(
			new RegisteredBankAccount.RegisteredBankAccountId(registeredBankAccountJpaEntity.getRegisteredBankAccountId()+""),
			new RegisteredBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId()+""),
			new RegisteredBankAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
			new RegisteredBankAccount.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
			new RegisteredBankAccount.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
		);
	}
}