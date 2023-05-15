package com.dziadkouskaya.votingserver.repository;

import com.dziadkouskaya.votingserver.entity.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends MongoRepository<Poll, Long> {
}
