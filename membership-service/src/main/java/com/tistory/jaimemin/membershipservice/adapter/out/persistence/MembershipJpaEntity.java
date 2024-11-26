package com.tistory.jaimemin.membershipservice.adapter.out.persistence;

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
@Table(name = "membership")
public class MembershipJpaEntity {

	@Id
	@GeneratedValue
	private Long membershipId;

	private String name;

	private String address;

	private String email;

	private Boolean isValid;

	private Boolean isCorp;

	public MembershipJpaEntity(String name, String address, String email, Boolean isValid, Boolean isCorp) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.isValid = isValid;
		this.isCorp = isCorp;
	}
}
