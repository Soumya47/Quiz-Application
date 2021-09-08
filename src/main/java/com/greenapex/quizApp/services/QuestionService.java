package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Question;
import com.greenapex.quizApp.entities.Quiz;
import com.greenapex.quizApp.exceptions.ResourceNotFoundException;
import com.greenapex.quizApp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    public Question addAndUpdateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestion(Integer questionId) throws ResourceNotFoundException {
        Optional<Question> byId = questionRepository.findById(questionId);
        try{
            if(!byId.isPresent()) {
                throw new ResourceNotFoundException("No Question found with "+questionId+" question id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byId.get();
    }

    public List<Question> getAllQuestionByQuizId(Integer quizId) throws ResourceNotFoundException {

        List<Question> questionByQuizId = questionRepository.getQuestionByQuizId(quizId);
        if(questionByQuizId.isEmpty()) {
            throw new ResourceNotFoundException("No Question found with "+quizId+" quiz id");
        }
        return questionByQuizId;
    }

}
