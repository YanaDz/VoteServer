package com.dziadkouskaya.votingserver.entity.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class ShortQuestion {
    private String id;
    private String question;
    private List<String> availableAnswers = new ArrayList<>();
}
