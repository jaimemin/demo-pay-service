package com.tistory.jaimemin.membershipservice.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jaimemin.common.WebAdapter;
import com.tistory.jaimemin.membershipservice.application.port.in.FindMembershipCommand;
import com.tistory.jaimemin.membershipservice.application.port.in.FindMembershipUseCase;
import com.tistory.jaimemin.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping("/membership/{membershipId}")
	ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {
		FindMembershipCommand command = FindMembershipCommand.builder()
			.membershipId(membershipId)
			.build();

		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
}
