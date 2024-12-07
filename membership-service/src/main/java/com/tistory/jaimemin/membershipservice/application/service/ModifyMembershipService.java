package com.tistory.jaimemin.membershipservice.application.service;

import javax.transaction.Transactional;

import com.tistory.jaimemin.common.UseCase;
import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.tistory.jaimemin.membershipservice.adapter.out.persistence.MembershipMapper;
import com.tistory.jaimemin.membershipservice.application.port.in.ModifyMembershipCommand;
import com.tistory.jaimemin.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.tistory.jaimemin.membershipservice.application.port.out.ModifyMembershipPort;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

	private final MembershipMapper membershipMapper;

	private final ModifyMembershipPort modifyMembershipPort;

	@Override
	public Membership modifyMembership(ModifyMembershipCommand command) {
		MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
			new Membership.MembershipId(command.getMembershipId()),
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);

		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}