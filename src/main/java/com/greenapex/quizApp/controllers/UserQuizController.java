package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.UserQuiz;
import com.greenapex.quizApp.services.UserQuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserQuizController {
    @Autowired
    UserQuizService userQuizService;


    @GetMapping("/userquiz")
    public List<UserQuiz> getAllUserQuiz() {
        return userQuizService.getAll();
    }

    @GetMapping("/userquiz/{id}")
    public UserQuiz getUserQuizById(@PathVariable Integer id) {
        return userQuizService.getUserQuiz(id);
    }

    @PostMapping("/userquiz")
    public UserQuiz addUserQuiz(@RequestBody UserQuiz userQuiz) {
        return userQuizService.addUserQuiz(userQuiz);
    }
}
