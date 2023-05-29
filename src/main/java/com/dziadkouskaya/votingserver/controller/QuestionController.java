package com.dziadkouskaya.votingserver.controller;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.SearchRequest;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import com.dziadkouskaya.votingserver.facade.QuestionFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Page<ShortQuestion> getAllQuestions(SearchRequest searchRequest) {
        return questionFacade.getAllQuestions(searchRequest);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Question createQuestion(@RequestBody QuestionDto questionDto) {
        return questionFacade.createQuestion(questionDto);
    }

    @GetMapping(value = "/{id}")
    public Question getById(@PathVariable String id) {
        return questionFacade.getById(id);
    }

    @GetMapping(value = "/search")
    public Page<Question> searchQustionByParams(SearchRequest searchRequest) {
        return questionFacade.findByParams(searchRequest);
    }

    @PutMapping(value = "/{id}")
    public Question updateQuestion(@PathVariable String id, @RequestBody QuestionDto updatedQuestion) {
        return questionFacade.updateQuestion(id, updatedQuestion);
    }

    @GetMapping(value = "/type")
    public Page<ShortQuestion> getAllQuestionsByType(SearchRequest searchRequest) {
        return questionFacade.getAllByType(searchRequest);
    }

    @GetMapping(value = "/size", produces = APPLICATION_JSON_VALUE)
    public Page<ShortQuestion> getAllQuestionsByAnswersNumber(SearchRequest searchRequest) {
        return questionFacade.findByAnswersNumber(searchRequest);
    }

    @GetMapping(value = "/number")
    public Integer getQuestionNumberByAnswers(SearchRequest  searchRequest) {
        return questionFacade.findQuestionNumberByAnswerNumber(searchRequest);
    }

}
