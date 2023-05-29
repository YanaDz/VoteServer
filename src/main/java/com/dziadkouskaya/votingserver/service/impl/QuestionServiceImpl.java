package com.dziadkouskaya.votingserver.service.impl;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.SearchRequest;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import com.dziadkouskaya.votingserver.exception.ResourceNotFoundException;
import com.dziadkouskaya.votingserver.repository.QuestionRepo;
import com.dziadkouskaya.votingserver.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.dziadkouskaya.votingserver.utils.Constants.QUESTION_NOT_FOUND;

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

    @Override
    public Question createQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Page<ShortQuestion> getAllQuestions(SearchRequest searchRequest) {
        return questionRepo.findAllQuestions(searchRequest.getPageRequest());
    }

    @Override
    public Page<ShortQuestion> getAllByType(String type, Pageable pageable) {
        return questionRepo.findAllQuestionsByType(type, pageable);
    }

    @Override
    public Question getById(String id) {
        var question = questionRepo.findById(id);
        if (question.isEmpty()) {
            throw  new ResourceNotFoundException(String.format(QUESTION_NOT_FOUND, id));
        }
        return question.get();
    }

    @Override
    public Page<Question> findBy(SearchRequest searchRequest) {
        return questionRepo.findQuestionByQuestionLikeOrAvailableAnswersContainsAllIgnoreCase(searchRequest.getSearch(), searchRequest.getSearch(), searchRequest.getPageRequest());
    }

    @Override
    public Question updateQuestion(Question newQuestion) {
        return questionRepo.save(newQuestion);
    }

    @Override
    public Page<ShortQuestion> findByQuestionNumber(Integer size, PageRequest pageable) {
        return questionRepo.findAllQuestionsByAnswerNumber(size, pageable);
    }

    @Override
    public Integer findQuestionNumberByAnswerNumber(Integer size) {
        return questionRepo.findQuestionNumberByAnswerNumber(size);
    }
}
