package com.example.storage.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1 and u.password = ?2 and u.status = ?3")
    User findUserBy(String email, String password, String status);

}