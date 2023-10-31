package com.hjp.db.domain.question.repository;

import com.hjp.db.domain.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByOrderByIdDesc();

    Page<Question> findDistinctBySubjectContainsOrContentContainsOrAuthor_usernameContainsOrAnswers_contentContainsOrAnswers_author_usernameContains(String kw, String kw1, String kw2, String kw3, String kw4, Pageable pageable);
}
