package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.UserQuiz;
import com.greenapex.quizApp.repositories.UserQuizRepository;
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
public class UserQuizServiceTest {

    @Mock
    UserQuizRepository userQuizRepository;

    @InjectMocks
    UserQuizService userQuizService;

    @BeforeEach
    public void setUp() {
        Mockito.when(userQuizRepository.save(Mockito.any())).thenReturn(dummyUserQuiz());
        Mockito.when(userQuizRepository.findAll()).thenReturn(dummyUserQuizList());
        Mockito.when(userQuizRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyUserQuiz()));
    }

    @Test
    public void addUserQuiz() throws Exception {
        UserQuiz userQuiz = userQuizService.addUserQuiz(dummyUserQuiz());
        assertTrue(userQuiz.getQuizId()==1);
        assertTrue(userQuiz.getUserId()==1);
    }

    @Test
    public void getAllUserQuizzes() throws Exception {
        List<UserQuiz> userQuizList = userQuizService.getAll();
        assertEquals(3,userQuizList.size());
        assert (userQuizList.get(1).getUserId()==2);
    }

    @Test
    public void getUserQuizById() throws Exception {
        UserQuiz userQuiz = userQuizService.getUserQuiz(1);
        assert (userQuiz.getUserId()==1);
        assert (userQuiz.getQuizId()==1);
    }

    private static List<UserQuiz> dummyUserQuizList() {
        List<UserQuiz> userQuizzes = new ArrayList<>();
        userQuizzes.add(new UserQuiz(1,1,1));
        userQuizzes.add(new UserQuiz(2,2,1));
        userQuizzes.add(new UserQuiz(3,1,2));
        return userQuizzes;
    }


    private static UserQuiz dummyUserQuiz() {
        UserQuiz userQuiz = new UserQuiz();
        userQuiz.setId(1);
        userQuiz.setUserId(1);
        userQuiz.setQuizId(1);
        return userQuiz;
    }
}