package com.hjp.db.domain.question.entity;

import com.hjp.db.base.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
public class Question extends BaseEntity {

    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
}
