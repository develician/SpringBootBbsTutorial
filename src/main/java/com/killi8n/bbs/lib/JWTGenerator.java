package com.killi8n.bbs.lib;

import java.util.Calendar;
import java.util.Date;

import com.killi8n.bbs.models.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTGenerator {

    private String hashKey;

    public JWTGenerator(String hashKey) {
        this.hashKey = hashKey;
    }

    public String Generate(Account account) {
        String compactJws;

        Calendar calendar = Calendar.getInstance();
        Date nowDate = calendar.getTime();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        Date expirationDate = calendar.getTime();

        Claims claims = Jwts.claims();
        claims.put("username", account.getUsername());
        claims.put("email", account.getEmail());

        compactJws = Jwts.builder().setClaims(claims).setIssuer("bbs.killi8n.com").setIssuedAt(nowDate)
                .setSubject("userInfo").signWith(SignatureAlgorithm.HS512, this.hashKey).setExpiration(expirationDate)
                .compact();
        return compactJws;
    }

    public Boolean Verify(String token) {
        try {
            Jwts.parser().setSigningKey(this.hashKey).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String VerifyUser(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(this.hashKey).parseClaimsJws(token).getBody();
            String username = claims.get("username").toString();
            return username;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}