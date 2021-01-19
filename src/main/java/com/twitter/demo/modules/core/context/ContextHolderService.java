package com.twitter.demo.modules.core.context;

public interface ContextHolderService {

    ContextHolder getUserState();

    void setUserState(ContextHolder contextHolder);

}
