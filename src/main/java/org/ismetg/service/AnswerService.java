package org.ismetg.service;

import org.ismetg.dto.request.CorrectAnswerAddRequestDto;
import org.ismetg.entity.Answer;
import org.ismetg.entity.Question;
import org.ismetg.exception.ErrorType;
import org.ismetg.exception.ExamException;
import org.ismetg.repository.AnswerRepository;
import org.ismetg.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService extends ServiceManager<Answer, Long> {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService) {
        super(answerRepository);
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    /**
     * kayıtlı bir soruya yeni cevap eklemek için
     * @param questionId cevap eklenmesi istenen sorunun id'si
     * @param answerText cevap metni
     */
    public void addAnswer(Long questionId , String answerText) {
        Optional<Question> question = questionService.findById(questionId);
        if (question.isEmpty()){
            throw new ExamException(ErrorType.QUESTION_NOT_FOUND);
        }
        Answer answer = Answer.builder()
                .question(question.get())
                .answerText(answerText)
                .build();
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long answerId){
        Optional<Answer> answer = answerRepository.findById(answerId);
        if (answer.isEmpty()){
            throw new ExamException(ErrorType.ANSWER_NOT_FOUND);
        }
        answerRepository.delete(answer.get());
    }

    /**
     * doğru cevap eklemeyi sağlayan kod eklemeden önce soru ve cevap var mı diye ve girilen cevap girilen soruya ait mi diye kontrol ediyor.
     * @param dto
     */
    public void addcorrectAnswer(CorrectAnswerAddRequestDto dto) {
        Optional<Question> question = questionService.findById(dto.questionId());
        if (question.isEmpty()) {
            throw new ExamException(ErrorType.QUESTION_NOT_FOUND);
        }
        Optional<Answer> answer = findById(dto.answerId());
        if (answer.isEmpty()) {
            throw new ExamException(ErrorType.ANSWER_NOT_FOUND);
        }
        if (!answer.get().getQuestion().equals(question.get())) {
            throw new ExamException(ErrorType.ANSWER_NOT_BELONG_QUESTION);
        }
        question.get().setCorrectAnswer(answer.get());
        questionService.save(question.get());
    }
}
