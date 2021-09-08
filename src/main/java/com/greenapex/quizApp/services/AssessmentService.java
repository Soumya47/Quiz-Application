package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Assessment;
import com.greenapex.quizApp.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AssessmentService {
    @Autowired
    AssessmentRepository assessmentRepository;

    public List<Assessment> getAssessmentOfAUser(Integer userId) {
        return assessmentRepository.getAssessmentOfAUser(userId);
    }

    public String getAssessmentResult(Integer userId) {
        return assessmentRepository.getResultsOfUser(userId)+
                " out of "+assessmentRepository.getTotalQuestionAttendByUser(userId);
    }

    public Assessment addAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public List<Map<String,Object>> getAllResultOfAUser(Integer userId){
        return assessmentRepository.getAllResultOfAUser(userId);
    }

    public List<Map<String,Object>> getAllResultByUserAndQuiz(Integer userId,Integer quizId) {
        return assessmentRepository.getResultsByUserIdAndQuizId(userId,quizId);
    }
}
