package com.tistory.jaimemin.membershipservice.application.port.out;

import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.tistory.jaimemin.membershipservice.domain.Membership;

public interface ModifyMembershipPort {

	MembershipJpaEntity modifyMembership(
		Membership.MembershipId membershipId
		, Membership.MembershipName membershipName
		, Membership.MembershipEmail membershipEmail
		, Membership.MembershipAddress membershipAddress
		, Membership.MembershipIsValid membershipIsValid
		, Membership.MembershipIsCorp membershipIsCorp
	);
}
