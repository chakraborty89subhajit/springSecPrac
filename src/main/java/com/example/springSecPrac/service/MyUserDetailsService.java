package com.example.springSecPrac.service;

import com.example.springSecPrac.entity.UserPrincipal;
import com.example.springSecPrac.entity.Users;
import com.example.springSecPrac.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
private UserRepo repo;

    //loaduserdetailsservice will fetch the user details from the databse as per the username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByusername(username);
        if (user==null){
            System.out.println("user not found");
            throw  new UsernameNotFoundException("user not found");
        }
        return  new UserPrincipal(user);
    }
}
