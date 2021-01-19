package com.twitter.demo.modules;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    public static final String PERMISSIONS = "PERMISSIONS";

    public static String token(String signing, String subject, String issuer, String type, String audience,
                               String expiration, List<String> permissions) {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.setTimeInMillis(System.currentTimeMillis() + Long.parseLong(expiration));
        Date date = calendar.getTime();
        return Jwts.builder().signWith(Keys.hmacShaKeyFor(signing.getBytes()), SignatureAlgorithm.HS256)
                .setHeaderParam("type", type).setIssuer(issuer).setAudience(audience).setSubject(subject)
                .setExpiration(date)
                .claim(PERMISSIONS, permissions).compact();

    }

    public static JwtInfo info(String token, String signing) {
        assert signing != null;
        var signingKey = signing.getBytes();
        var parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);
        List<String> strings = (List<String>) parsedToken.getBody()
                .get(PERMISSIONS);
        List<SimpleGrantedAuthority> permissions = strings.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new JwtInfo(parsedToken.getBody().getSubject(), permissions);
    }
}