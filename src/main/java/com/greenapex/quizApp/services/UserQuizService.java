package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.User;
import com.greenapex.quizApp.entities.UserQuiz;
import com.greenapex.quizApp.repositories.UserQuizRepository;
import com.greenapex.quizApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizService {
    @Autowired
    UserQuizRepository userQuizRepository;

    public UserQuiz addUserQuiz(UserQuiz userQuiz) {
        return userQuizRepository.save(userQuiz);
    }

    public List<UserQuiz> getAll() {
        return userQuizRepository.findAll();
    }

    public UserQuiz getUserQuiz(Integer id) {
        return userQuizRepository.findById(id).get();
    }




}
