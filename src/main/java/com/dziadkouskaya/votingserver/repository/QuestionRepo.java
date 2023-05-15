package com.dziadkouskaya.votingserver.repository;

import com.dziadkouskaya.votingserver.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<Question, String> {
}
