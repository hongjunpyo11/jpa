package com.hjp.db.domain.question.repository;

import com.hjp.db.domain.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QuestionRepositoryCustom {
    Page<Question> findByKwV3(String kw, Pageable pageable);
}
