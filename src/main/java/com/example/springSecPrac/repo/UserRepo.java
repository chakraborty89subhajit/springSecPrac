package com.example.springSecPrac.repo;

import com.example.springSecPrac.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<Users, Integer> {


    Users findByusername(String username);

}
