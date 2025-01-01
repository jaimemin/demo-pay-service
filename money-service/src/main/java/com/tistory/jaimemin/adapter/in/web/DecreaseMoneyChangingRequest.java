package com.tistory.jaimemin.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseMoneyChangingRequest {

	private String targetMembershipId;

	private int amount;
}
