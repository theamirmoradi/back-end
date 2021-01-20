package com.twitter.demo.domain;

import com.twitter.demo.modules.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User extends BaseEntity {

    private String username;
    private String password;

    @JoinColumn(name = "user_id")
    @OneToMany
    private List<Tweet> tweets;

    @OneToOne
    private UserProfile userProfile;
}
