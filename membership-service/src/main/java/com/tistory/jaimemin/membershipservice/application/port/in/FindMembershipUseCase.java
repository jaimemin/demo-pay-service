package com.tistory.jaimemin.membershipservice.application.port.in;

import com.tistory.jaimemin.membershipservice.domain.Membership;

import common.UseCase;

@UseCase
public interface FindMembershipUseCase {

	Membership findMembership(FindMembershipCommand command);
}
