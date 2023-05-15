package com.dziadkouskaya.votingserver.entity;

import com.dziadkouskaya.votingserver.enumeration.VoterRole;
import com.dziadkouskaya.votingserver.enumeration.VotingCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollRequest {
    private Long creator;
    private List<Question> polls = new ArrayList<>();
    private VotingCoverage votingCoverage;
    private Long voutingEntityId;
    private Set<VoterRole> voterRoles = new HashSet<>();

}
