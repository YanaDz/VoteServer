package com.dziadkouskaya.votingserver.mapper;

import com.dziadkouskaya.votingserver.entity.Poll;
import com.dziadkouskaya.votingserver.entity.PollRequest;
import com.dziadkouskaya.votingserver.entity.Question;
import com.dziadkouskaya.votingserver.entity.dto.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PollMapper {

    @Mapping(target = "creator", source = "request.creator", ignore = true)
    @Mapping(target = "polls", expression = "java( toQuestions(request.getPolls() ))")
    @Mapping(target = "votingCoverage", source = "request.votingCoverage")
    @Mapping(target = "voutingEntityId", source = "request.voutingEntityId")
    @Mapping(target = "voterRoles", source = "request.voterRoles")
    Poll toEntity(PollRequest  request);


    Question toEntity(QuestionDto dto);

    default List<Question> toQuestions(List<QuestionDto> dtos){
        return dtos.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }
}
