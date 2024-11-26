package com.tistory.jaimemin.membershipservice.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipMapper;
import com.tistory.jaimemin.membershipservice.application.port.in.RegisterMembershipCommand;
import com.tistory.jaimemin.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.tistory.jaimemin.membershipservice.application.port.out.RegisterMembershipPort;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

	private final MembershipMapper membershipMapper;

	private final RegisterMembershipPort registerMembershipPort;

	@Override
	public Membership registerMembership(RegisterMembershipCommand command) {
		MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);

		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}
