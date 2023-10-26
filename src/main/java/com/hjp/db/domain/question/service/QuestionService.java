package com.hjp.db.domain.question.service;

import com.hjp.db.domain.member.entity.Member;
import com.hjp.db.domain.question.entity.Question;
import com.hjp.db.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public Question write(Member author, String subject, String content) {
        Question question = Question
                .builder()
                .author(author)
                .subject(subject)
                .content(content)
                .build();

        return questionRepository.save(question);
    }

    public Optional<Question> findById(long id) {
        return questionRepository.findById(id);
    }

}
