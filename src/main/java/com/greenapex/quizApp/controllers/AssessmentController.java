package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Assessment;
import com.greenapex.quizApp.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AssessmentController {
    @Autowired
    AssessmentService assessmentService;

    /*Get the assessment details of a user by user id*/

    @GetMapping("/assessment/{userId}")
    public List<Assessment> getAssessmentDetails(@PathVariable Integer userId) {
        return assessmentService.getAssessmentOfAUser(userId);
    }

    /*Get the assessment result of a user by user id*/

    @GetMapping("/assessres/{userId}")
    public String getAssessmentResult(@PathVariable Integer userId) {
        return assessmentService.getAssessmentResult(userId);
    }

    /*adding the answers */

    @PostMapping("/assessment")
    public Assessment addAssessmentByUser(@RequestBody Assessment assessment) {
        return assessmentService.addAssessment(assessment);
    }

    @GetMapping("/res/{userId}")
    public List<Map<String,Object>> getAllResultOfAUser(@PathVariable Integer userId) {
        return assessmentService.getAllResultOfAUser(userId);
    }

    @GetMapping("/res/{userId}/{quizId}")
    public List<Map<String,Object>> getAllResultByUserAndQuiz(@PathVariable Integer userId,@PathVariable Integer quizId) {
        return assessmentService.getAllResultByUserAndQuiz(userId,quizId);
    }

}
