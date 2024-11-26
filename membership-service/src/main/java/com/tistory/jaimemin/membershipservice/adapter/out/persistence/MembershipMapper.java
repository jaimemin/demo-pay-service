package com.tistory.jaimemin.membershipservice.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.tistory.jaimemin.membershipservice.domain.Membership;

@Component
public class MembershipMapper {

	public Membership mapToDomainEntity(MembershipJpaEntity jpaEntity) {
		return Membership.generateMember(
			new Membership.MembershipId(jpaEntity.getMembershipId() + ""),
			new Membership.MembershipName(jpaEntity.getName()),
			new Membership.MembershipEmail(jpaEntity.getEmail()),
			new Membership.MembershipAddress(jpaEntity.getAddress()),
			new Membership.MembershipIsValid(jpaEntity.getIsValid()),
			new Membership.MembershipIsCorp(jpaEntity.getIsCorp())
		);
	}
}
