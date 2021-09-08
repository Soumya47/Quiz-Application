package com.greenapex.quizApp.repositories;

import com.greenapex.quizApp.entities.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizRepository extends JpaRepository<UserQuiz,Integer> {

}
