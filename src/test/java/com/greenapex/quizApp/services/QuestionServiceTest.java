package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Question;
import com.greenapex.quizApp.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionService questionService;

    @BeforeEach
    public void setUp() {
        Mockito.when(questionRepository.save(Mockito.any())).thenReturn(dummyQuestion()) ;
        Mockito.when(questionRepository.getQuestionByQuizId(Mockito.any())).thenReturn(dummyQuestionList());
        Mockito.when(questionRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyQuestion()));
    }

    @Test
    public void addQuestion() throws Exception{
        Question question = questionService.addAndUpdateQuestion(dummyQuestion());
        assertTrue(question.getQuestionId()==1);
        assertEquals("some question ?",question.getQuestion());
        assertTrue(question.getQuizId()==1);
    }

    @Test
    public void getQuestionById() throws Exception {
        Question question = questionService.getQuestion(1);
        assertEquals("some question ?",question.getQuestion());
    }

    @Test
    public void getQuestionByQuizId() throws Exception {
        List<Question> questions = questionService.getAllQuestionByQuizId(1);
        assert (questions.size()==3);
        assertTrue(questions.get(1).getQuestionId()==2);
    }

    private static Question dummyQuestion() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestion("some question ?");
        question.setQuizId(1);
        return question;
    }

    private static List<Question> dummyQuestionList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1,"some question?",1));
        questions.add(new Question(2,"some question1?",1));
        questions.add(new Question(3,"some question2?",1));
        return questions;
    }

}