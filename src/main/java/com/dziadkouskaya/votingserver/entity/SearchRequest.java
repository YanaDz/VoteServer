package com.dziadkouskaya.votingserver.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class SearchRequest extends PageDescriptionRequest {
    private String search;
}
