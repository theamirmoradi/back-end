package com.twitter.demo.modules.activity;

import com.nila.masterclass.modules.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "activity", indexes = {@Index(columnList = "entity", name = "idx1_activity"),
        @Index(columnList = "type", name = "idx2_activity"), @Index(columnList = "username", name = "idx3_activity"),
        @Index(columnList = "user_id", name = "idx4_activity")})
public class Activity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String entity;
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ActivityType type;
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String username;
    @NotNull
    @Column(name = "user_id", nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String userId;
    @Column(columnDefinition = "TEXT")
    private String description;
}
