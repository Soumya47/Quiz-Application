package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Quiz;
import com.greenapex.quizApp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    /*Get the list of a quiz*/

    @GetMapping("/quiz")
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    /*Get the quiz by quiz id*/

    @GetMapping("/quiz/{quizId}")
    public Quiz getQuiz(@PathVariable Integer quizId) {
        return quizService.getSpecificQuiz(quizId);
    }

    /*Adding the quiz in database*/

    @PostMapping("/quiz")
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return  quizService.addAndUpdateQuiz(quiz);
    }

    /*Updating the quiz in database*/

    @PutMapping("/quiz")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return quizService.addAndUpdateQuiz(quiz);
    }

}
