package com.twitter.demo.modules.core.context;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContextHolder {

    private String id;
    private String userDeviceId;
    private Boolean haveSubscription;
}
