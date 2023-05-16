package com.dziadkouskaya.votingserver.facade;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;

import java.util.List;

public interface QuestionFacade {
    List<Question> getAllQuestions();

    Question createQuestion(QuestionDto questionDto);

}
