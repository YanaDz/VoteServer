package com.dziadkouskaya.votingserver.entity;

import com.dziadkouskaya.votingserver.enumeration.VoterRole;
import com.dziadkouskaya.votingserver.enumeration.VotingCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "poll")
public class Poll {
    @Id
    private String id;
    private String creator;
    private List<Question> polls;
    private VotingCoverage votingCoverage;
    private Long voutingEntityId;
    private Set<VoterRole> voterRoles;


}
