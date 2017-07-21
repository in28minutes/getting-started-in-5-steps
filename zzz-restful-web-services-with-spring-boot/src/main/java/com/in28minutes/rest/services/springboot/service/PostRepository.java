package com.in28minutes.rest.services.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.services.springboot.bean.Post;
import com.in28minutes.rest.services.springboot.bean.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}