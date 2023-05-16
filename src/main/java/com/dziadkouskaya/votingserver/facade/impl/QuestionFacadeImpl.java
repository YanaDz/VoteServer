package com.dziadkouskaya.votingserver.facade.impl;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import com.dziadkouskaya.votingserver.facade.QuestionFacade;
import com.dziadkouskaya.votingserver.mapper.PollMapper;
import com.dziadkouskaya.votingserver.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class QuestionFacadeImpl implements QuestionFacade {
    private final QuestionService questionService;
    private final PollMapper pollMapper;
    @Override
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @Override
    public Question createQuestion(QuestionDto questionDto) {
        var question = pollMapper.toEntity(questionDto);
        return questionService.createQuestion(question);
    }
}
