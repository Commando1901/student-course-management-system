package com.mandip.student_course_management.repository;

import com.mandip.student_course_management.entity.User;
import com.mandip.student_course_management.entity.type.AuthProviderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String Username);

    Optional<User> findByProviderIdAndProviderType(String providerId, AuthProviderType providerType);
}
