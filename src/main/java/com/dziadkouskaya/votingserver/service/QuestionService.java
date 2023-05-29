package com.dziadkouskaya.votingserver.service;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.SearchRequest;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface QuestionService {
    List<Question> createQuestions(List<Question> questions);

    Question createQuestion(Question question);

    Page<ShortQuestion> getAllQuestions(SearchRequest searchRequest);

    Page<ShortQuestion> getAllByType(String type, Pageable pageable);

    Question getById(String id);

    Page<Question> findBy(SearchRequest searchRequest);

    Question updateQuestion(Question newQuestion);

    Page<ShortQuestion> findByQuestionNumber(Integer size, PageRequest pageable);

    Integer findQuestionNumberByAnswerNumber(Integer size);
}
