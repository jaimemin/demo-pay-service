package com.tistory.jaimemin.membershipservice.application.port.in;

import com.tistory.jaimemin.common.UseCase;
import com.tistory.jaimemin.membershipservice.domain.Membership;

@UseCase
public interface RegisterMembershipUseCase {

	Membership registerMembership(RegisterMembershipCommand command);
}
