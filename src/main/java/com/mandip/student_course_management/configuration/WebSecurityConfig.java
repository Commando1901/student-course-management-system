package com.mandip.student_course_management.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    //here we cconfigure our security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

//        so we write here formlogin(default) so already login means don't check for login means all request made public
//        httpSecurity
//                .formLogin(Customizer.withDefaults());



//        we can also configure authenication for different requests
//        so basically it required authentication for get courses and we can get students without authentication
//          httpSecurity
//                  .authorizeHttpRequests(auth -> auth
//                          .requestMatchers("/api/students/**").permitAll()
//                          .requestMatchers("/api/courses/**").authenticated()
//                  )
//                  .formLogin(Customizer.withDefaults());



//we can also authenticate using given user roles
//but for that we have to create roles for user we can create roles in application properties or using UserDetailsService
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/students/**").permitAll()
                        .requestMatchers("/api/courses/**").hasRole("ADMIN")

                )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    // here can't direct store password like "pass" instead of it we have use {noop}pass or password encode
    // for paswordencoder we have create bean in modelmapperconfig or any config exist
    @Bean
    UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("admin")
                .password(passwordEncoder.encode("pass"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("teacher")
                .password(passwordEncoder.encode("pass123"))
                .roles("TEACHER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
}
