package com.dziadkouskaya.votingserver.facade.impl;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;
import com.dziadkouskaya.votingserver.facade.PollFacade;
import com.dziadkouskaya.votingserver.service.PollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class PollFacadeImpl implements PollFacade {
    private final PollService pollService;

    @Override
    public Poll createPoll(PollRequest request) {
        return pollService.createPoll(request);
    }

    @Override
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }
}
