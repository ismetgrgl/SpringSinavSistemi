package org.ismetg.dto.response;

import org.ismetg.dto.request.AnswerSaveRequestDto;

import java.util.List;

public record QuestionFindAllResponseDto(
        String questionText,
        Double point,
        List<AnswerFindAllResponseDto> answers
) {
}
