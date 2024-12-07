package com.tistory.jaimemin.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmbankingResult {

	// 0: 성공, 1: 실패
	private int resultCode;
	
	public FirmbankingResult(int resultCode) {
		this.resultCode = resultCode;
	}
}
