package org.ismetg.dto.request;

public record CorrectAnswerAddRequestDto(
        Long questionId,
        Long answerId
) {
}
