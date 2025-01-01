package com.tistory.jaimemin.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_money")
public class MemberMoneyJpaEntity {

	@Id
	@GeneratedValue
	private Long memberMoneyId;

	private Long membershipId;

	private int balance;

	public MemberMoneyJpaEntity(Long membershipId, int balance) {
		this.membershipId = membershipId;
		this.balance = balance;
	}
}
