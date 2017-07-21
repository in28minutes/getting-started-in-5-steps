package com.in28minutes.rest.services.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.services.springboot.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}