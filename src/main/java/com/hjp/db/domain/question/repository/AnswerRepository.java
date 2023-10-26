package com.hjp.db.domain.question.repository;

import com.hjp.db.domain.question.entity.Answer;
import com.hjp.db.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
