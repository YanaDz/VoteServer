package com.dziadkouskaya.votingserver.service.impl;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;
import com.dziadkouskaya.votingserver.repository.PollRepository;
import com.dziadkouskaya.votingserver.service.PollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {
    private final PollRepository pollRepo;

    @Override
    public Poll createPoll(PollRequest request) {
        return null;
    }

    @Override
    public List<Poll> getAllPolls() {
        return null;
    }
}
