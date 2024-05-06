package org.ismetg.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
	QUESTION_NOT_FOUND(5001,
			"aranan id ile soru bulunamadı.",
			HttpStatus.NOT_FOUND),
	ANSWER_NOT_FOUND(5001,
							   "aranan id ile cevap bulunamadı.",
					   HttpStatus.NOT_FOUND),
	ANSWER_NOT_BELONG_QUESTION(5001,
							 "girilen cevap girilen soruya ait değil.",
					 HttpStatus.NOT_FOUND);

	private Integer code;
	private String message;
	private HttpStatus httpStatus;
	
}