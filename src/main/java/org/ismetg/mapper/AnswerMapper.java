package org.ismetg.mapper;

import org.ismetg.dto.request.AnswerSaveRequestDto;
import org.ismetg.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    Answer answerSaveRequestDtoToAnswer(AnswerSaveRequestDto answerDto);
}
