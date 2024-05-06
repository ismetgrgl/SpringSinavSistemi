package org.ismetg.dto.request;

import jdk.dynalink.linker.LinkerServices;
import org.ismetg.entity.Answer;

import java.util.List;

public record QuestionSaveRequestDto(
        String questionText,
        String subject,
        Double point,
        List<AnswerSaveRequestDto> answers

) {
}
