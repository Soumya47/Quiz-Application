package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Quiz;
import com.greenapex.quizApp.repositories.QuizRepository;
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
public class QuizServiceTest {
    
    @Mock
    QuizRepository quizRepository;
    
    @InjectMocks
    QuizService quizService;

    @BeforeEach
    public void setUp()  {
        Mockito.when(quizRepository.save(Mockito.any())).thenReturn(dummyQuiz());
        Mockito.when(quizRepository.findAll()).thenReturn(dummyQuizList());
        Mockito.when(quizRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyQuiz()));
    }

    @Test
    public void addAndUpdateQuiz() throws Exception{
        Quiz quiz = quizService.addAndUpdateQuiz(dummyQuiz());
        assertTrue(quiz.getQuizName()=="GK");
        assertTrue(quiz.getQuizId()==1);
    }


    @Test
    public void getAllQuiz() {
        List<Quiz> quizzes = quizService.getAllQuiz();
        assertEquals(3,quizzes.size());
        assertTrue(quizzes.get(2).getQuizName()=="Cultural");
    }

    @Test
    public void getSpecificQuiz() {
        Quiz quiz = quizService.getSpecificQuiz(1);
        assertEquals("GK",quiz.getQuizName());
    }

    private static List<Quiz> dummyQuizList() {
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz(1,"GK"));
        quizzes.add(new Quiz(2,"Sports"));
        quizzes.add(new Quiz(3,"Cultural"));
        return quizzes;
    }

    private static Quiz dummyQuiz() {
        Quiz quiz = new Quiz(1,"GK");
        return quiz;
    }
}