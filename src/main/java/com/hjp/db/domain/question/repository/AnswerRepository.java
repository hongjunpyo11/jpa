package com.hjp.db.domain.question.repository;

import com.hjp.db.domain.question.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
