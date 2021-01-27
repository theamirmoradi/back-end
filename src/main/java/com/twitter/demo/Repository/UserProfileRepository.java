package com.twitter.demo.Repository;

import com.twitter.demo.domain.UserProfile;
import com.twitter.demo.modules.core.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Base64;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends BaseRepository<UserProfile> {

    Optional<UserProfile> findByUserId(long userId);
}
