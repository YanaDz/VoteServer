package com.dziadkouskaya.votingserver.service;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;

import java.util.List;

public interface PollService {
    Poll createPoll(Poll request);

    List<Poll> getAllPolls();

}
