package com.tistory.jaimemin.adapter.out.persistence;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request_firmbanking")
public class FirmbankingRequestJpaEntity {

	@Id
	@GeneratedValue
	private Long requestFirmbankingId;

	private String fromBankName;

	private String fromBankAccountNumber;

	private String toBankName;

	private String toBankAccountNumber;

	private int moneyAmount; // only won

	private int firmbankingStatus; // 0: 요청, 1: 완료, 2: 실패

	private String uuid;

	public FirmbankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName,
		String toBankAccountNumber, int moneyAmount, int firmbankingStatus, UUID uuid) {
		this.fromBankName = fromBankName;
		this.fromBankAccountNumber = fromBankAccountNumber;
		this.toBankName = toBankName;
		this.toBankAccountNumber = toBankAccountNumber;
		this.moneyAmount = moneyAmount;
		this.firmbankingStatus = firmbankingStatus;
		this.uuid = uuid.toString();
	}

}
