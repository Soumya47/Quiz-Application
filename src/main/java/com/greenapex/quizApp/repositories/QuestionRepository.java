package com.greenapex.quizApp.repositories;

import com.greenapex.quizApp.entities.Question;
import com.greenapex.quizApp.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query(value = "select * from question  where quiz_id = ?1",nativeQuery = true)
    List<Question> getQuestionByQuizId(Integer quizId);
}
