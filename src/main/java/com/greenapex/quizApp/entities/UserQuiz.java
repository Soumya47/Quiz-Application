package com.greenapex.quizApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_quiz")
public class UserQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "quiz_id")
    private Integer quizId;

    public UserQuiz() {
    }

    public UserQuiz(Integer id, Integer userId, Integer quizId) {
        this.id = id;
        this.userId = userId;
        this.quizId = quizId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
}
