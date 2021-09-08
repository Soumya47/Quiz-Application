package com.greenapex.quizApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Integer quizId;
    @Column(name = "quiz_name")
    private String quizName;

    public Quiz() {
    }

    public Quiz(Integer quizId, String quizName) {
        this.quizId = quizId;
        this.quizName = quizName;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }


}
