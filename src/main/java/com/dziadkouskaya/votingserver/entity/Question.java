package com.dziadkouskaya.votingserver.entity;

import com.dziadkouskaya.votingserver.enumeration.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "question")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private String id;
    @NonNull
    private String question;
    @NonNull
    private QuestionType questionType;

    private List<String> availableAnswers = new ArrayList<>();
}
