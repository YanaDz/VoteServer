package com.dziadkouskaya.votingserver.facade.impl;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.SearchRequest;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import com.dziadkouskaya.votingserver.facade.QuestionFacade;
import com.dziadkouskaya.votingserver.mapper.PollMapper;
import com.dziadkouskaya.votingserver.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionFacadeImpl implements QuestionFacade {
    private final QuestionService questionService;
    private final PollMapper pollMapper;
    @Override
    public Page<ShortQuestion> getAllQuestions(SearchRequest searchRequest) {
        return questionService.getAllQuestions(searchRequest);
    }

    @Override
    public Question createQuestion(QuestionDto questionDto) {
        var question = pollMapper.toEntity(questionDto);
        return questionService.createQuestion(question);
    }

    @Override
    public Question getById(String id) {
        return questionService.getById(id);
    }

    @Override
    public Page<Question> findByParams(SearchRequest searchRequest) {
        return questionService.findBy(searchRequest);
    }

    @Override
    public Question updateQuestion(String id, QuestionDto dto) {
        var existedQuestion = getById(id);
        var newQuestion = pollMapper.updateQuestion(existedQuestion, dto);
        return questionService.updateQuestion(newQuestion);
    }

    @Override
    public Page<ShortQuestion> getAllByType(SearchRequest searchRequest) {
        return questionService.getAllByType(searchRequest.getSearch(), searchRequest.getPageRequest());
    }

    @Override
    public Page<ShortQuestion> findByAnswersNumber(SearchRequest searchRequest) {
        var size = Integer.parseInt(searchRequest.getSearch());
        return questionService.findByQuestionNumber(size, searchRequest.getPageRequest());
    }

    @Override
    public Integer findQuestionNumberByAnswerNumber(SearchRequest searchRequest) {
        return questionService.findQuestionNumberByAnswerNumber(Integer.parseInt(searchRequest.getSearch()));
    }
}
