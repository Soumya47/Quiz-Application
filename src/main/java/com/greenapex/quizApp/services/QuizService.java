package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Quiz;
import com.greenapex.quizApp.exceptions.ResourceNotFoundException;
import com.greenapex.quizApp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public Quiz addAndUpdateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public Quiz getSpecificQuiz(Integer quizId) throws ResourceNotFoundException {
        Optional<Quiz> byId = quizRepository.findById(quizId);
        if(!byId.isPresent()) {
            throw new ResourceNotFoundException("Quiz id "+quizId+" not present");
        }
        return byId.get();
    }


}

