package org.ismetg.util;

import org.ismetg.entity.Answer;
import org.ismetg.entity.Question;
import org.ismetg.repository.AnswerRepository;
import org.ismetg.repository.QuestionRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DemoData implements ApplicationRunner {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public DemoData(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }
    public void createDemoData() {
        createQuestion();
    }

    private void createQuestion() {

        //soru 1 ve cevapları
        Question question1 = Question.builder()
                .questionText("bir saat kaç dakikadır?")
                .subject("Genel Kültür")
                .point(10d)
                .build();

        Answer answer1 = Answer.builder()
                .answerText("30")
                .question(question1)
                .build();

        Answer answer2 = Answer.builder()
                .answerText("1")
                .question(question1)
                .build();

        Answer answer3 = Answer.builder()
                .answerText("60")
                .question(question1)
                .build();

        Answer answer4 = Answer.builder()
                .answerText("100")
                .question(question1)
                .build();

        //soru 2 ve cevapları
        Question question2 = Question.builder()
                .questionText("2+2")
                .subject("Matematik")
                .point(10d)
                .build();

        Answer answer5 = Answer.builder()
                .answerText("5")
                .question(question2)
                .build();
        Answer answer6 = Answer.builder()
                .answerText("-4")
                .question(question2)
                .build();
        Answer answer7 = Answer.builder()
                .answerText("4")
                .question(question2)
                .build();

        //soru 3 ve cevapları
        Question question3 = Question.builder()
                .questionText("5x3")
                .subject("Matematik")
                .point(15d)
                .build();

        Answer answer8 = Answer.builder()
                .answerText("15")
                .question(question3)
                .build();
        Answer answer9 = Answer.builder()
                .answerText("-15")
                .question(question3)
                .build();
        Answer answer10 = Answer.builder()
                .answerText("0")
                .question(question3)
                .build();

        questionRepository.saveAll(List.of(question1, question2, question3));
        answerRepository.saveAll(List.of(answer1, answer2, answer3, answer4, answer5, answer6 , answer7, answer8, answer9, answer10));

        question1.setCorrectAnswer(answer3);
        question2.setCorrectAnswer(answer7);
        question3.setCorrectAnswer(answer8);
        questionRepository.saveAll(List.of(question1, question2, question3));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //createDemoData();
    }

}
