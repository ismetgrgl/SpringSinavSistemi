package org.ismetg.service;

import org.ismetg.dto.request.CorrectAnswerAddRequestDto;
import org.ismetg.dto.request.QuestionSaveRequestDto;
import org.ismetg.dto.response.QuestionFindAllResponseDto;
import org.ismetg.dto.response.QuestionFindByResponseDto;
import org.ismetg.entity.Answer;
import org.ismetg.entity.Question;
import org.ismetg.exception.ErrorType;
import org.ismetg.exception.ExamException;
import org.ismetg.mapper.AnswerMapper;
import org.ismetg.mapper.QuestionMapper;
import org.ismetg.repository.QuestionRepository;
import org.ismetg.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService extends ServiceManager<Question, Long> {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;
    }

    /**
     * soru ekleme işlemi soru eklenirken cevaplarda ekleniyor.
     *
     * @param dto girilen soru ve cevap bilgileri.
     */
    public void addQuestion(QuestionSaveRequestDto dto) {
        Question question = QuestionMapper.INSTANCE.questionSaveRequestDtoToQuestion(dto);

        // Cevapları ekleyerek kaydetme
        List<Answer> answers = dto.answers().stream()
                .map(answerDto -> {
                    Answer answer = AnswerMapper.INSTANCE.answerSaveRequestDtoToAnswer(answerDto);
                    answer.setQuestion(question);
                    return answer;
                })
                .collect(Collectors.toList());
        question.setAnswers(answers);
        questionRepository.save(question);
    }

    /**
     * sistemde kayıtlı olan tüm soruları getiriyor.
     *
     * @return QuestionFindAllResponseDto listesi getiriyor.
     */
    public List<QuestionFindAllResponseDto> getAllQuestions() {
        List<QuestionFindAllResponseDto> responseDtoList = new ArrayList<>();
        findAll().forEach(dto -> responseDtoList.add(QuestionMapper.INSTANCE.questionFindAllResponse(dto)));
        return responseDtoList;
    }

    /**
     * girilen Id ye göre önce kontrol ediyor. Sonra varsa dto döndürüyor.
     *
     * @param id dışardan istenen soru id'si
     * @return QuestionFindByResponseDto dönüyor.
     */
    public QuestionFindByResponseDto findByIdResponseDto(Long id) {
        Optional<Question> question = findById(id);
        if (question.isEmpty()) {
            throw new ExamException(ErrorType.QUESTION_NOT_FOUND);
        }
        return QuestionMapper.INSTANCE.questionFindByResponseDto(question.get());
    }

    /**
     * QuestionRepository içerisinde yazılmış hazır sorgu ile soruları konusuna göre getiriyor.
     * Sonrasında for ile listeyi QuestionFindAllResponseDto listesine dönüştürüp ekliyor.
     * @param subject dışardan istenen konu
     * @return QuestionFindAllResponseDto listesi dönüyor.
     */
    public List<QuestionFindAllResponseDto> getQuestionsBySubject(String subject) {
        List<QuestionFindAllResponseDto> responseDtoList = new ArrayList<>();

        List<Question> questions = questionRepository.findBySubjectIgnoreCase(subject);

        for (Question question : questions) {
            responseDtoList.add(QuestionMapper.INSTANCE.questionFindAllResponse(question));
        }
        return responseDtoList;
    }


}
