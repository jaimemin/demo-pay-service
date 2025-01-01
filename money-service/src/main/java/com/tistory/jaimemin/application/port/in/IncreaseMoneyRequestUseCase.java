package com.tistory.jaimemin.application.port.in;

import com.tistory.jaimemin.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {
	
	MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
