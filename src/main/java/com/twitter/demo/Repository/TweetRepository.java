package com.twitter.demo.Repository;

import com.twitter.demo.domain.Tweet;
import com.twitter.demo.modules.core.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends BaseRepository<Tweet> {
    List<Tweet> findByUserId(long userId);
}
