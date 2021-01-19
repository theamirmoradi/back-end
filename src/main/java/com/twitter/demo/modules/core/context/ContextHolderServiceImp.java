package com.twitter.demo.modules.core.context;

import com.nila.masterclass.modules.core.util.ThreadLocal;

import org.springframework.stereotype.Service;

@Service
public class ContextHolderServiceImp implements ContextHolderService {
    private static final String KEY = "USER_STATE";

    @Override
    public ContextHolder getUserState() {
        return (ContextHolder) ThreadLocal.getObject(KEY);
    }

    @Override
    public void setUserState(ContextHolder contextHolder) {
        ThreadLocal.setObject(KEY, contextHolder);
    }
}
