package com.hjp.db.domain.question.entity;

import com.hjp.db.base.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@Builder
public class Question extends BaseEntity {

    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
}
