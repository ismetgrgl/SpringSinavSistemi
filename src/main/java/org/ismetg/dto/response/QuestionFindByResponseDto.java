package org.ismetg.dto.response;

import java.util.List;

public record QuestionFindByResponseDto(

        String questionText,
        Double point,
        List<AnswerFindAllResponseDto> answers,

        Long correctanswerid,

        String correctanswertext

) {

}
