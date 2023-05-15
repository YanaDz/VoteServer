package com.dziadkouskaya.votingserver.facade;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;

import java.util.List;

public interface PollFacade {

    Poll createPoll(PollRequest request);

    List<Poll> getAllPolls();


}
