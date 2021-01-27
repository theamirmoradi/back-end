package com.twitter.demo.Service;

import com.twitter.demo.domain.Tweet;
import com.twitter.demo.modules.core.BaseRepository;
import com.twitter.demo.modules.core.BaseServiceImp;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImp extends BaseServiceImp<Tweet> implements TweetService{
    public TweetServiceImp(BaseRepository<Tweet> repository) {
        super(repository);
    }
}
