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
public class UserProfile extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String description;

    @Column
    private String phone;

    @Column
    private long userId;
}
