package com.hjp.db.domain.question.service;

import com.hjp.db.domain.question.entity.Question;
import com.hjp.db.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public Question write(String subject, String content) {
        Question question = Question
                .builder()
                .subject(subject)
                .content(content)
                .build();
        return questionRepository.save(question);
    }
}
