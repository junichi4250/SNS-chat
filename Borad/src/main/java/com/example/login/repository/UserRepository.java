package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.entity.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

}