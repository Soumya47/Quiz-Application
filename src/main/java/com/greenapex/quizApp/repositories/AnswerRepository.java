package com.greenapex.quizApp.repositories;

import com.greenapex.quizApp.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query(value = "select * from answer where question_id = ?1",nativeQuery = true)
    List<Answer> getAllAnswerByQuestionId(Integer questionId);

//    @Modifying
////    @Transactional
////    @Query("insert into answer (answer, is_correct, question_id) VALUES (:a, :c, :q)")
////    void addAnswer(@Param("a") String answer,@Param("c") boolean isCorrect,@Param("q") Integer questionId);
}
