package com.tistory.jaimemin.application.port.out;

import com.tistory.jaimemin.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.tistory.jaimemin.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

	RegisteredBankAccountJpaEntity createRegisteredBankAccount(
		RegisteredBankAccount.MembershipId membershipId,
		RegisteredBankAccount.BankName bankName,
		RegisteredBankAccount.BankAccountNumber bankAccountNumber,
		RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
	);
}
