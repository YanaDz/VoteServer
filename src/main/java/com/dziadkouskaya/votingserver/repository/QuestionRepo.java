package com.dziadkouskaya.votingserver.repository;

import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.dto.ShortQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuestionRepo extends MongoRepository<Question, String> {
    Page<Question> findQuestionByQuestionLikeOrAvailableAnswersContainsAllIgnoreCase(String s, String answer,
                                                                                     Pageable pageable);

    @Query(value = "{}", fields = "{_id:1, question : 1, availableAnswers: 1}")
    Page<ShortQuestion> findAllQuestions(Pageable pageable);

    @Query(value = "{questionType : ?0}", fields = "{_id:1, question : 1, availableAnswers: 1}")
    Page<ShortQuestion> findAllQuestionsByType(String questionType, Pageable pageable);

    @Query(value = "{availableAnswers:{$size: ?0}}", fields = "{_id:1, question : 1, availableAnswers: 1}")
    Page<ShortQuestion> findAllQuestionsByAnswerNumber(Integer size, PageRequest pageable);

    @Query(value = "{availableAnswers:{$size: ?0}}", count = true)
    Integer findQuestionNumberByAnswerNumber(Integer size);

}
