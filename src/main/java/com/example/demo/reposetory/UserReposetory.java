package com.example.demo.reposetory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.Users;

@Repository
public interface UserReposetory extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}

