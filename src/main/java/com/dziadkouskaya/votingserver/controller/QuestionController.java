package com.dziadkouskaya.votingserver.controller;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import com.dziadkouskaya.votingserver.facade.QuestionFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = QuestionController.PATH)
public class QuestionController {
    public static final String PATH = "/questions";

    private final QuestionFacade questionFacade;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionFacade.getAllQuestions();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Question createQuestion(@RequestBody QuestionDto questionDto) {
        return questionFacade.createQuestion(questionDto);
    }
}
