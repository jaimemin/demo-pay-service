package com.tistory.jaimemin.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * a -> b 실물계좌로 요청을 하기 위한 Request
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFirmbankingRequest {

	private String fromBankName;

	private String fromBankAccountNumber;

	private String toBankName;

	private String toBankAccountNumber;

	private int moneyAmount;
}