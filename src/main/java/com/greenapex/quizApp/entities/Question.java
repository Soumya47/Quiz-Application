package com.greenapex.quizApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "question_id")
    private Integer questionId;
    @Column(name = "question")
    private String question;

    @Column(name = "quiz_id")
    private Integer quizId;

    public Question() {
    }



    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Question(Integer questionId, String question, Integer quizId) {
        this.questionId = questionId;
        this.question = question;
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", quizId=" + quizId +
                '}';
    }
}
