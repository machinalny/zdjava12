package org.zdjavapol12.springcourse.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain filterChain) throws IOException, ServletException {
        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(req, res);
            return;
        }

        try {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(req);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(req, res);
        } catch (JWTDecodeException jwtDecodeException) {
            filterChain.doFilter(req, res);

        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) throws JWTDecodeException {
        String token = req.getHeader("Authorization");

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("XYZ"))
                .build().verify(token.replace("Bearer ", ""));

        String user = decodedJWT.getSubject();
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(Arrays.stream(decodedJWT.getClaim("Role").asArray(String.class)).collect(Collectors.joining(",")));


        if (user != null) {
            return new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities);
        }
        return null;

    }
}
