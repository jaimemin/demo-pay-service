package com.tistory.jaimemin.membershipservice.application.service;

import org.springframework.stereotype.Service;

import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipMapper;
import com.tistory.jaimemin.membershipservice.application.port.in.FindMembershipCommand;
import com.tistory.jaimemin.membershipservice.application.port.in.FindMembershipUseCase;
import com.tistory.jaimemin.membershipservice.application.port.out.FindMembershipPort;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

	private final MembershipMapper membershipMapper;

	private final FindMembershipPort findMembershipPort;

	@Override
	public Membership findMembership(FindMembershipCommand command) {
		MembershipJpaEntity jpaEntity = findMembershipPort.findMembership(
			new Membership.MembershipId(command.getMembershipId()));

		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}
