package com.hjp.db.domain.question.repository;

import com.hjp.db.domain.question.entity.QQuestion;
import com.hjp.db.domain.question.entity.Question;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.hjp.db.domain.question.entity.QQuestion.*;

@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {
    private final JPAQueryFactory jpqQueryFactory;

    public Page<Question> findByKwV3(String kw, Pageable pageable) {
        List<Question> questions = jpqQueryFactory
                .selectDistinct(question)
                .from(question)
                .where(
                        question.subject.contains(kw)
                                .or(question.content.contains(kw))
                )
                .fetch();

        return new PageImpl<>(questions, pageable, questions.size());
    }
}
