package com.tistory.jaimemin.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyChangingResultDetail {

	private String moneyChangingRequestId;

	/**
	 * 0: 증액,
	 * 1: 감액
	 */
	private int moneyChangingType;

	/**
	 * 0: 성공,
	 * 1: 실패,
	 *
	 * enum으로 표현한다면 추가하면 좋은 정보
	 * 실패 - 잔액 부족,
	 * 실패 - 멤버십 없음,
	 * 실패 - 머니 변액 요청 없음
	 */
	private int moneyChangingResultStatus;

	private int amount;
}
