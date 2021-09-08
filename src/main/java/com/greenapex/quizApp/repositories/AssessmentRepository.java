package com.greenapex.quizApp.repositories;

import com.greenapex.quizApp.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface AssessmentRepository extends JpaRepository<Assessment , Integer> {

    @Query(value = "select * from assessment where user_id = ?1",nativeQuery = true)
    List<Assessment> getAssessmentOfAUser(Integer userId);

    @Query(value = "select count(answer.is_correct) from assessment join answer on assessment.answer_id = answer.answer_id && answer.is_correct = 1 && assessment.user_id = ?1",nativeQuery = true)
    Integer getResultsOfUser(Integer userId);

    @Query(value = "select count(answer.is_correct) from assessment join answer on assessment.answer_id = answer.answer_id && assessment.user_id = ?1",nativeQuery = true)
    Integer getTotalQuestionAttendByUser(Integer userId);

    @Query(value ="select user.username,question.quiz_id,answer.answer,answer.is_correct,question.question from user join assessment join answer join question on user.user_id = assessment.user_id and assessment.answer_id = answer.answer_id and answer.question_id = question.question_id where user.user_id=?1 ", nativeQuery = true)
    List<Map<String,Object>> getAllResultOfAUser(Integer userId);

    @Query(value = " select user.username,question.quiz_id,answer.answer,answer.is_correct,question.question from user join assessment join answer join question on user.user_id = assessment.user_id and assessment.answer_id = answer.answer_id and answer.question_id = question.question_id where user.user_id=?1 and question.quiz_id = ?2 " ,nativeQuery = true)
    List<Map<String,Object>> getResultsByUserIdAndQuizId(Integer userId,Integer quizId);
}
