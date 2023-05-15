package com.dziadkouskaya.votingserver.entity;

import com.dziadkouskaya.votingserver.enumeration.QuetionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "vote")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private Long id;
    @NonNull
    private String question;
    @NonNull
    private QuetionType pollItemType;

    private List<String> availableAnswers = new ArrayList<>();
}
