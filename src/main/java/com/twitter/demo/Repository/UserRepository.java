package com.twitter.demo.Repository;

import com.twitter.demo.domain.User;
import com.twitter.demo.modules.core.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsername(String username);
}
