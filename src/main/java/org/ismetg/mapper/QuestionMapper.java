package org.ismetg.mapper;

import org.ismetg.dto.request.CorrectAnswerAddRequestDto;
import org.ismetg.dto.request.QuestionSaveRequestDto;
import org.ismetg.dto.response.QuestionFindAllResponseDto;
import org.ismetg.dto.response.QuestionFindByResponseDto;
import org.ismetg.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    Question questionSaveRequestDtoToQuestion(QuestionSaveRequestDto dto);
    QuestionFindAllResponseDto questionFindAllResponse(Question question);

    @Mapping(target = "correctanswerid", source = "question.correctAnswer.id")
    @Mapping(target = "correctanswertext", source = "question.correctAnswer.answerText")
    QuestionFindByResponseDto questionFindByResponseDto(Question question);

}
