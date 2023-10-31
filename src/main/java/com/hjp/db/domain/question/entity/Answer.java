package com.hjp.db.domain.question.entity;

import com.hjp.db.base.jpa.BaseEntity;
import com.hjp.db.domain.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class Answer extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member author;
    @ManyToOne(fetch = LAZY)
    private Question question;
    @Column(columnDefinition = "TEXT")
    private String content;
}
