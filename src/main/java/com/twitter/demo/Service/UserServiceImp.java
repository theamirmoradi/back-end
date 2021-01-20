package com.twitter.demo.Service;

import com.twitter.demo.domain.User;
import com.twitter.demo.modules.core.BaseRepository;
import com.twitter.demo.modules.core.BaseServiceImp;

public class UserServiceImp extends BaseServiceImp<User> implements UserService{
    public UserServiceImp(BaseRepository<User> repository) {
        super(repository);
    }
}
