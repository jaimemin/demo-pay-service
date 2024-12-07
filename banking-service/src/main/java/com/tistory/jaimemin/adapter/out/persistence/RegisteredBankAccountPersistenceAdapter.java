package com.tistory.jaimemin.adapter.out.persistence;

import com.tistory.jaimemin.application.port.out.RegisterBankAccountPort;
import com.tistory.jaimemin.common.PersistenceAdapter;
import com.tistory.jaimemin.domain.RegisteredBankAccount;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

	private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

	@Override
	public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId
		, RegisteredBankAccount.BankName bankName
		, RegisteredBankAccount.BankAccountNumber bankAccountNumber
		, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
		return bankAccountRepository.save(
			new RegisteredBankAccountJpaEntity(
				membershipId.getMembershipId(),
				bankName.getBankName(),
				bankAccountNumber.getBankAccountNumber(),
				linkedStatusIsValid.isLinkedStatusIsValid()
			)
		);
	}
}
