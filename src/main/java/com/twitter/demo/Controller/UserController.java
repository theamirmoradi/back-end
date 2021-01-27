package com.twitter.demo.Controller;

import com.twitter.demo.Repository.TweetRepository;
import com.twitter.demo.Repository.UserProfileRepository;
import com.twitter.demo.Service.TweetService;
import com.twitter.demo.Service.UserProfileService;
import com.twitter.demo.Service.UserService;
import com.twitter.demo.domain.Tweet;
import com.twitter.demo.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("UserController")
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TweetService tweetService;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/tweets")
    public ResponseEntity<List<Tweet>> getAllTweet() {
        return ResponseEntity.ok(tweetService.find());
    }

    @GetMapping("/user-tweets")
    public ResponseEntity<List<Tweet>> getAllUserTweet(@RequestParam long userId) {
        return ResponseEntity.ok(tweetRepository.findByUserId(userId));
    }

    @GetMapping("/tweets/{id}")
    public ResponseEntity<Tweet> getTweet(@PathVariable long id) {
        return ResponseEntity.ok(tweetService.find(id));
    }

    @PostMapping("/update-profile")
    public ResponseEntity<UserProfile> changeProfile(@RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.update(userProfile.getId(), userProfile));
    }

    @GetMapping("/user-profile/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable long id) {
        return ResponseEntity.ok(userProfileRepository.findByUserId(id).get());
    }

    @PostMapping("/add-tweet")
    public ResponseEntity<Tweet> addTweet(@RequestBody Tweet tweet) {
        return ResponseEntity.ok(tweetService.create(tweet));
    }

    @PostMapping("/edit-tweet")
    public ResponseEntity<Tweet> editTweet(@RequestBody Tweet tweet) {
        return ResponseEntity.ok(tweetService.update(tweet.getId(), tweet));
    }
}
