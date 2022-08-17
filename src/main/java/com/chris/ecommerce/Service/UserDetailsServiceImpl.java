package com.chris.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chris.ecommerce.Model.User;
import com.chris.ecommerce.Repo.UserCRUDRepository;
import com.chris.ecommerce.Repo.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 
    @Autowired
    private UserCRUDRepository userRepository;
    
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
        
        
        
    }
    
    
 
}
