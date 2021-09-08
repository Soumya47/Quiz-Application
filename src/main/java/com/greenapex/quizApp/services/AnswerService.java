package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Answer;
import com.greenapex.quizApp.exceptions.ResourceNotFoundException;
import com.greenapex.quizApp.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public Answer addAndUpdateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer getAnswer(Integer answerId)  {

        Optional<Answer> byId = answerRepository.findById(answerId);

            try{
                if(!byId.isPresent()){
                    throw new ResourceNotFoundException("No Answer found with "+answerId+" answer id");
                }
            } catch (ResourceNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }


        return byId.get();
    }

    public List<Answer> getAllAnswerByQuestionId(Integer questionId) throws ResourceNotFoundException {
        List<Answer> allAnswerByQuestionId = answerRepository.getAllAnswerByQuestionId(questionId);

        if(allAnswerByQuestionId.isEmpty()) {
            throw new ResourceNotFoundException("No Answer found with "+questionId+" question id");
        }
        return allAnswerByQuestionId;
    }

}
