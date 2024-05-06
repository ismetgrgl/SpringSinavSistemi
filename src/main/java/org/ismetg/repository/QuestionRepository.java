package org.ismetg.repository;

import org.ismetg.dto.response.QuestionFindAllResponseDto;
import org.ismetg.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubjectIgnoreCase(String subject);
}
