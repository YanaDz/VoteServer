package com.dziadkouskaya.votingserver.facade.impl;

import com.dziadkouskaya.votingserver.mapper.PollMapper;
import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;
import com.dziadkouskaya.votingserver.facade.PollFacade;
import com.dziadkouskaya.votingserver.service.PollService;
import com.dziadkouskaya.votingserver.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class PollFacadeImpl implements PollFacade {
    private final PollService pollService;
    private final PollMapper pollMapper;
    private final QuestionService questionService;

    @Override
    public Poll createPoll(PollRequest request) {
        var poll = pollMapper.toEntity(request);
        return pollService.createPoll(poll);
    }

    @Override
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }
}
