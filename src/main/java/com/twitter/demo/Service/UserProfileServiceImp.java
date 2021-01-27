package com.twitter.demo.Service;

import com.twitter.demo.domain.UserProfile;
import com.twitter.demo.modules.core.BaseRepository;
import com.twitter.demo.modules.core.BaseServiceImp;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImp extends BaseServiceImp<UserProfile> implements UserProfileService{
    public UserProfileServiceImp(BaseRepository<UserProfile> repository) {
        super(repository);
    }
}
