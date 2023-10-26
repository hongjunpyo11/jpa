package com.hjp.db.domain.question.entity;

import com.hjp.db.base.jpa.BaseEntity;
import com.hjp.db.domain.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class Answer extends BaseEntity {
    @ManyToOne
    private Member author;
    @ManyToOne
    private Question question;
    @Column(columnDefinition = "TEXT")
    private String content;
}
