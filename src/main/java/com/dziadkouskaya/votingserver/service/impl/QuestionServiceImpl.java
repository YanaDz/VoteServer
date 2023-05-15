package com.dziadkouskaya.votingserver.service.impl;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.repository.QuestionRepo;
import com.dziadkouskaya.votingserver.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepo questionRepo;
    @Override
    public List<Question> createQuestions(List<Question> questions) {
        return questions.stream()
            .map(questionRepo::save)
            .collect(Collectors.toList());
    }
}
