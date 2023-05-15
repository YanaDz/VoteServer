package com.dziadkouskaya.votingserver.entity.dto;

import com.dziadkouskaya.votingserver.enumeration.QuetionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class QuestionDto {
    @NonNull
    private String question;
    @NonNull
    private QuetionType pollItemType;

    private List<String> availableAnswers;
}
