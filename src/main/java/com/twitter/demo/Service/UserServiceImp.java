package com.twitter.demo.Service;

import com.twitter.demo.Repository.UserRepository;
import com.twitter.demo.domain.Tweet;
import com.twitter.demo.domain.User;
import com.twitter.demo.domain.UserProfile;
import com.twitter.demo.modules.core.BaseRepository;
import com.twitter.demo.modules.core.BaseServiceImp;
import com.twitter.demo.modules.core.exception.Error;
import com.twitter.demo.modules.core.exception.ErrorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp extends BaseServiceImp<User> implements UserService{

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetService tweetService;

    public UserServiceImp(BaseRepository<User> repository) {
        super(repository);
    }


    @Override
    public long login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent())
            if (userOptional.get().getPassword().equals(password))
                return userOptional.get().getId();
        throw new Error(ErrorStatus.ACCOUNT_NOT_REGISTERED, User.class.getSimpleName(), "user not register", null);

    }

    @Override
    public long register(String username, String password) {
        User user = create(User.builder()
        .username(username)
        .password(password).build());
        UserProfile.builder().userId(user.getId());
        return user.getId();
    }

    @Override
    public Tweet addTweet(String text, long id) {
        Tweet tweet = Tweet.builder().text(text).userId(id).build();
        return tweetService.create(tweet);
    }

    @Override
    public void removeTweet(long id) {
        tweetService.delete(id);
    }
}
