package com.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.E_commerce.Repository.UserRepository;
import com.E_commerce.model.User;
//
//@Service
//public class userService 
//{    
//	  @Autowired
//	  UserRepository userrep;
//	
//	public void userRegistration(User u )
//	{
//		userrep.save(u);
//	}
//	 
//
//	
//}



@Service
public class userService {    

    @Autowired
    private UserRepository userrep;
   
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void userRegistration(User u) {
        userrep.save(u);
    }

    public List<User> getAllUsers() {
        return userrep.findAll();
    }

    public void approveUser(int userId) {
        User user = userrep.findById(userId).orElseThrow();
        user.setApproved(true);
        userrep.save(user);
    }

    public void rejectUser(int userId) {
        userrep.deleteById(userId);
    }
    public User findByEmail(String email) {
        return userrep.findByEmail(email).orElse(null);
    }


    public User findByEmailAndPassword(String email, String password) {
        Optional<User> userOpt = userrep.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    public User findById(int id) {
        return userrep.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

}
}


