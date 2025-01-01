package com.tistory.jaimemin.adapter.out.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "money_changing_request")
public class MoneyChangingRequestJpaEntity {

	@Id
	@GeneratedValue
	private Long moneyChangingRequestId;

	private String targetMembershipId;

	/**
	 * 0: 증액,
	 * 1: 감액
	 */
	private int moneyChangingType;

	private int moneyAmount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	/**
	 * 0: 요청,
	 * 1: 성공,
	 * 2: 실패
	 */
	private int changingMoneyStatus;

	private String uuid;

	public MoneyChangingRequestJpaEntity(String targetMembershipId
		, int moneyChangingType
		, int moneyAmount
		, Timestamp timestamp
		, int changingMoneyStatus
		, UUID uuid) {
		this.targetMembershipId = targetMembershipId;
		this.moneyChangingType = moneyChangingType;
		this.moneyAmount = moneyAmount;
		this.timestamp = timestamp;
		this.changingMoneyStatus = changingMoneyStatus;
		this.uuid = uuid.toString();
	}
}
