package com.mandip.student_course_management.security;

import com.mandip.student_course_management.entity.User;
import com.mandip.student_course_management.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    //use for transfer exception to globalexception handler
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            //“Print the request URL”
            log.info("incoming request: {}", request.getRequestURI());

            // Get value of Authorization header
            // example request -> Authorization: Bearer abc123xyz
            final String requestTokenHeader = request.getHeader("Authorization");

            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
                //if not token then go to next filter
                filterChain.doFilter(request, response);
                return;
            }

            //we get -> "Bearer abc123xyz"
            //so for token we split and taken 1st index string which is actually token
            // this line will return -> abc123xyz
            String token = requestTokenHeader.split("Bearer ")[1];
//        String token = requestTokenHeader.substring(7).trim();

            String username = authUtil.getUsernameFromToken(token);

            // if we get username and securitycontextholder is null cause we want to fill securitycontextholder so it must be null
            // remember it's work of filters that it fill securitycontextholder
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userRepository.findByUsername(username).orElseThrow();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                //now this we want to store this token in security context holder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

            //then filled securitycontextholder move forward in filterchain
            filterChain.doFilter(request, response);

            //now we create our filter but we also add this in filterchain
            //so go to websecurityconfig
        } catch (Exception ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }
}
