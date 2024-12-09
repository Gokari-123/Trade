package com.Trade.example.Trade.Service;

import com.Trade.example.Trade.Entity.User;
import com.Trade.example.Trade.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User createUser(User user) throws Exception {
        if (userRepository.existsById(user.getUserId())) {
            throw new Exception("User Already Exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
      return  userRepository.save(user);
    }

    public User authenticate(String userId, String password) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("Authentication Failed"));
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new Exception("Authentication Failed");
        }
        return user;
    }

}
