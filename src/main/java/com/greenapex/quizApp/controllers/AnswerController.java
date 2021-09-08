package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Answer;
import com.greenapex.quizApp.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

     /* get all answers by question ID */

    @GetMapping("/ansques/{questionId}")
    public List<Answer> getAllAnswerByQuestionId(@PathVariable Integer questionId) {
        return answerService.getAllAnswerByQuestionId(questionId);

    }

    /* get answer by answer id */

    @GetMapping("/ans/{answerId}")
    public Answer getAnswer(@PathVariable Integer answerId) {
        return answerService.getAnswer(answerId);
    }

    /* adding answer to a question in database*/

    @PostMapping("/ans")
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerService.addAndUpdateAnswer(answer);
    }

    /* Updating the Answer */

    @PutMapping("/ans")
    public Answer updateAnswer(@RequestBody Answer answer) {
        return answerService.addAndUpdateAnswer(answer);
    }



}
