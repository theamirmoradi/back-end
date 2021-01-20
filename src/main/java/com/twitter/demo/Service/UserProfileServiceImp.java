package com.twitter.demo.Service;

import com.twitter.demo.domain.UserProfile;
import com.twitter.demo.modules.core.BaseRepository;
import com.twitter.demo.modules.core.BaseServiceImp;

public class UserProfileServiceImp extends BaseServiceImp<UserProfile> implements UserProfileService{
    public UserProfileServiceImp(BaseRepository<UserProfile> repository) {
        super(repository);
    }
}
