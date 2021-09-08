package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Question;
import com.greenapex.quizApp.entities.Quiz;
import com.greenapex.quizApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /*get questions by question ID*/

    @GetMapping("/ques/{questionId}")
    public Question getQuestion(@PathVariable Integer questionId) {
        return questionService.getQuestion(questionId);
    }

    /*get all the question of the perticuler quiz by quiz id*/

    @GetMapping("/quesquiz/{quizId}")
    public List<Question> getAllQuestionByQuizId(@PathVariable Integer quizId) {
        return questionService.getAllQuestionByQuizId(quizId);
    }

    /*add the question to the database*/

    @PostMapping("/ques")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addAndUpdateQuestion(question);
    }

//    @PutMapping("/ques")
//    public Question updateQuestion(Question question) {
//        return questionService.addAndUpdateQuestion(question);
//    }
}
