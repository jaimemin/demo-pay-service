package com.tistory.jaimemin.membershipservice.adapter.out.persistence;

import com.tistory.jaimemin.common.PersistenceAdapter;
import com.tistory.jaimemin.membershipservice.application.port.out.FindMembershipPort;
import com.tistory.jaimemin.membershipservice.application.port.out.ModifyMembershipPort;
import com.tistory.jaimemin.membershipservice.application.port.out.RegisterMembershipPort;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

	private final MembershipMapper membershipMapper;

	private final SpringDataMembershipRepository membershipRepository;

	@Override
	public MembershipJpaEntity createMembership(Membership.MembershipName membershipName
		, Membership.MembershipEmail membershipEmail
		, Membership.MembershipAddress membershipAddress
		, Membership.MembershipIsValid membershipIsValid
		, Membership.MembershipIsCorp membershipIsCorp) {
		return membershipRepository.save(
			new MembershipJpaEntity(
				membershipName.getNameValue(),
				membershipEmail.getEmailValue(),
				membershipAddress.getAddressValue(),
				membershipIsValid.getIsValidValue(),
				membershipIsCorp.getIsCorpValue()
			)
		);
	}

	@Override
	public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
		return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
	}

	@Override
	public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId
		, Membership.MembershipName membershipName
		, Membership.MembershipEmail membershipEmail
		, Membership.MembershipAddress membershipAddress
		, Membership.MembershipIsValid membershipIsValid
		, Membership.MembershipIsCorp membershipIsCorp) {
		MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
		entity.setName(membershipName.getNameValue());
		entity.setAddress(membershipAddress.getAddressValue());
		entity.setEmail(membershipEmail.getEmailValue());
		entity.setIsCorp(membershipIsCorp.getIsCorpValue());
		entity.setIsValid(membershipIsValid.getIsValidValue());

		return membershipRepository.save(entity);
	}
}
