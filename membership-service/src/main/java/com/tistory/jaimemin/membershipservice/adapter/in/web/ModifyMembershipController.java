package com.tistory.jaimemin.membershipservice.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.common.WebAdapter;
import com.tistory.jaimemin.membershipservice.application.port.in.ModifyMembershipCommand;
import com.tistory.jaimemin.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

	private final ModifyMembershipUseCase modifyMembershipUseCase;

	@PostMapping(path = "/membership/modify")
	ResponseEntity<Membership> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {
		ModifyMembershipCommand command = ModifyMembershipCommand.builder()
			.membershipId(request.getMembershipId())
			.name(request.getName())
			.address(request.getAddress())
			.email(request.getEmail())
			.isValid(request.isValid())
			.isCorp(request.isCorp())
			.build();

		return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
	}
}
