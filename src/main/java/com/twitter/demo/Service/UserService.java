package com.twitter.demo.Service;

import com.twitter.demo.domain.Tweet;
import com.twitter.demo.domain.User;
import com.twitter.demo.modules.core.BaseService;

public interface UserService extends BaseService<User> {

    long login(String username, String password);

    long register(String username, String password);

    Tweet addTweet(String text, long id);

    void removeTweet(long id);

}
