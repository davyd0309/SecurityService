package pl.dawydiuk.SecurityService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@RestController
public class SecurityController {

    @PostMapping(value = "/login")
    public String login() throws UnsupportedEncodingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Collection<? extends GrantedAuthority> userRoles = authentication.getAuthorities();
        return Jwts.builder()
                .setSubject(userName)
                .addClaims(Map.of("roles", userRoles, "name", userName))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 2000000))
                .signWith(
                        SignatureAlgorithm.HS256,
                        "ZG)KB01hS9LsTuv".getBytes("UTF-8")
                )
                .compact();
    }


}
