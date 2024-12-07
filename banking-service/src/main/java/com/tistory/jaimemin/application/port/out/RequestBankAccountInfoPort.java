package com.tistory.jaimemin.application.port.out;

import com.tistory.jaimemin.adapter.out.external.bank.BankAccount;
import com.tistory.jaimemin.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

	BankAccount getBankAccountInfo(GetBankAccountRequest request) ;
}