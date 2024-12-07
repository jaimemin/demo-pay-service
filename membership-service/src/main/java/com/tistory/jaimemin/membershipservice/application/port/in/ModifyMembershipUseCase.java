package com.tistory.jaimemin.membershipservice.application.port.in;

import com.tistory.jaimemin.membershipservice.domain.Membership;

public interface ModifyMembershipUseCase {

	Membership modifyMembership(ModifyMembershipCommand command);
}
