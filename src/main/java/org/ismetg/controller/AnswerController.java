package org.ismetg.controller;

import lombok.RequiredArgsConstructor;
import org.ismetg.dto.request.CorrectAnswerAddRequestDto;
import org.ismetg.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.ismetg.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT+ANSWER)
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping(SAVE + "/{questionId}")
    public ResponseEntity<String> addAnswer(@PathVariable Long questionId, String answerText) {
        answerService.addAnswer(questionId, answerText);
        return ResponseEntity.ok("cevap eklendi");
    }

    @DeleteMapping(DELETE + "/{answerId}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long answerId) {
        answerService.deleteAnswer(answerId);
        return ResponseEntity.ok("cevap silindi");
    }

    @PutMapping("addcorrectanswer")
    public ResponseEntity<String> addCorrectAnswer(CorrectAnswerAddRequestDto dto){
        answerService.addcorrectAnswer(dto);
        return ResponseEntity.ok("Soruya doğru cevap eklendi.");
    }


}
