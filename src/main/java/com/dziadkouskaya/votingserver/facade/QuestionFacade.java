package com.dziadkouskaya.votingserver.facade;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.SearchRequest;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionFacade {
    Page<ShortQuestion> getAllQuestions(SearchRequest searchRequest);

    Question createQuestion(QuestionDto questionDto);

    Question getById(String id);

    Page<Question> findByParams(SearchRequest searchRequest);

    Question updateQuestion(String id, QuestionDto updatedQuestion);

    Page<ShortQuestion> getAllByType(SearchRequest searchRequest);

    Page<ShortQuestion> findByAnswersNumber(SearchRequest searchRequest);

    Integer findQuestionNumberByAnswerNumber(SearchRequest searchRequest);
}
