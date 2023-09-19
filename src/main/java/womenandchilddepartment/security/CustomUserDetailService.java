package womenandchilddepartment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.Admin;
import womenandchilddepartment.repo.AdminRepo;
//import womenandchilddepartment.model.User;
//import womenandchilddepartment.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = this.adminRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "email : " + username, 0));

        return user;
}}
