package com.twitter.demo.modules;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtInfo {

    private final String subject;
    private final List<SimpleGrantedAuthority> permissions;

    public JwtInfo(String subject, List<SimpleGrantedAuthority> permissions) {
        this.subject = subject;
        this.permissions = permissions;
    }

    public String getSubject() {
        return subject;
    }

    public List<SimpleGrantedAuthority> getPermissions() {
        return permissions;
    }
}
