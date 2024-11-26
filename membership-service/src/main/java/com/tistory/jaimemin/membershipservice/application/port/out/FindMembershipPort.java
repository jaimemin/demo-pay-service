package com.tistory.jaimemin.membershipservice.application.port.out;

import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.tistory.jaimemin.membershipservice.domain.Membership;

public interface FindMembershipPort {

	MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
