package com.twitter.demo.modules.activity;

import com.nila.masterclass.modules.core.specification.BaseSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ActivitySpecification extends BaseSpecification<Activity> {

    private static final long serialVersionUID = 1L;
    private final String entity;
    private final ActivityType type;
    private final String username;
    private final String userId;

    public ActivitySpecification(Long id, String entity, ActivityType type, String username, String userId) {
        super(id);
        this.entity = entity;
        this.type = type;
        this.username = username;
        this.userId = userId;
    }

    @Override
    public void prePredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (entity != null)
            addPredicate(builder.equal(root.get("entity"), entity));
        if (type != null)
            addPredicate(builder.equal(root.get("type"), type));
        if (userId != null)
            addPredicate(builder.equal(root.get("userId"), userId));
        if (username != null)
            addPredicate(builder.equal(root.get("username"), username));
    }
}
