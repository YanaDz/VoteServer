package com.dziadkouskaya.votingserver.service;

import com.dziadkouskaya.votingserver.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> createQuestions(List<Question> questions);

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

}
