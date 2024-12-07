package com.tistory.jaimemin.application.port.in;

import com.tistory.jaimemin.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

	RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
