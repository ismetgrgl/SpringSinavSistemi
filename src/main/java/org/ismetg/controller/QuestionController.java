package org.ismetg.controller;

import lombok.RequiredArgsConstructor;
import org.ismetg.dto.request.CorrectAnswerAddRequestDto;
import org.ismetg.dto.request.QuestionSaveRequestDto;
import org.ismetg.dto.response.AnswerFindAllResponseDto;
import org.ismetg.dto.response.QuestionFindAllResponseDto;
import org.ismetg.dto.response.QuestionFindByResponseDto;
import org.ismetg.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ismetg.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT+QUESTION)
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    /**
     * gelen veriler service katmanında işlenip kaydediliyor.
     * @param dto
     * @return
     */
    @PostMapping(SAVE)
    public ResponseEntity<String> addQuestion(@RequestBody QuestionSaveRequestDto dto){
        questionService.addQuestion(dto);
        return ResponseEntity.ok("Soru ekleme işlemi başarıyla tamamlandı.");
    }

    /**
     * soru ve cevapları QuestionFindAllResponseDto'ya göre getiriliyor.
     * @return
     */
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<QuestionFindAllResponseDto>> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping(FIND_BY_ID+"/{questionId}")
    public ResponseEntity<QuestionFindByResponseDto> findByIdResponseDto(@PathVariable Long questionId){
        return ResponseEntity.ok(questionService.findByIdResponseDto(questionId));
    }

    /**
     * soruları konusuna göre getiren istek.
     * @param subject dışardan istenen konu
     * @return
     */
    @GetMapping("getQuestionsBySubject")
    public ResponseEntity<List<QuestionFindAllResponseDto>> getQuestionsBySubject(@RequestParam(name = "search") String subject){
        return ResponseEntity.ok(questionService.getQuestionsBySubject(subject));
    }



}
