package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.User;
import com.greenapex.quizApp.exceptions.ResourceNotFoundException;
import com.greenapex.quizApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addAndUpdateUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    public List<User> getAllUser() throws ResourceNotFoundException {

        List<User> all = userRepository.findAll();
        if(all == null) {
            throw new ResourceNotFoundException("No Resource Found");
        }
        return all;
    }
//
    public User getSpecificUser(Integer userId) throws ResourceNotFoundException {

        User user = userRepository.findById(userId).get();
        if(user.getUserId() == null) {
            throw new ResourceNotFoundException("User with "+ user.getUserId()+" not Found");
        }
        return user;
    }
//
//    public String deleteUser(Integer userId) {
//        userRepository.deleteById(userId);
//        return "User Deleted";
//    }
//
//    public String updateUser(Integer userId, User user) {
//        return userRepository.findById(userId).map(user1 -> {
//            user1.setUserName(user.getUserName());
//            user1.setEmail(user.getEmail());
//            user1.setPassword(user.getPassword());
//            userRepository.save(user1);
//            return "User Updated";
//        }).orElseGet(()-> "Cannot Find the user"+userId);
//    }
}
