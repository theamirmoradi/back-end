package com.twitter.demo.domain;

import com.twitter.demo.modules.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Tweet extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "user_id")
    private Long userId;
}
