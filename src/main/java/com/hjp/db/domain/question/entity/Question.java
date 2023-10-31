package com.hjp.db.domain.question.entity;

import com.hjp.db.base.jpa.BaseEntity;
import com.hjp.db.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Question extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member author;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {PERSIST, REMOVE}, orphanRemoval = true)

    @OrderBy("id DESC")
    private List<Answer> answers = new ArrayList<>();

    public Answer writeAnswer(Member author, String content) {
        Answer answer = Answer
                .builder()
                .author(author)
                .question(this)
                .content(content)
                .build();

        answers.add(0, answer);

        return answer;
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }
}
