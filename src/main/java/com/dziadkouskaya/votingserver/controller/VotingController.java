package com.dziadkouskaya.votingserver.controller;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;
import com.dziadkouskaya.votingserver.facade.PollFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = VotingController.PATH)
@RequiredArgsConstructor
public class VotingController {
    public static final String PATH = "/polls";

    private final PollFacade pollFacade;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Poll createPoll(@RequestBody PollRequest request)  {
        return pollFacade.createPoll(request);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Poll> getAllPolls() {
        return pollFacade.getAllPolls();
    }
}
