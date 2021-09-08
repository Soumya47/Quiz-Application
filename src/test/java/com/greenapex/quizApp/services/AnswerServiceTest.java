package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.Answer;
import com.greenapex.quizApp.repositories.AnswerRepository;
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
public class AnswerServiceTest {

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private AnswerService answerService;

    @BeforeEach
    public void setUp() {
        Mockito.when(answerRepository.save(Mockito.any())).thenReturn(dummyAnswer());
        Mockito.when(answerRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyAnswer()));
        Mockito.when(answerRepository.getAllAnswerByQuestionId(Mockito.any())).thenReturn(dummyAnswerList());
    }

    @Test
    public void addAndUpdateAnswer() throws Exception {
        Answer answer = answerService.addAndUpdateAnswer(dummyAnswer());
        assertNotNull(answer.getAnswer());
        assertNotNull(answer.getCorrect());
        assertNotNull(answer.getQuestionId());
    }
    @Test
    public void getAnswer() throws Exception {
        Answer answer = answerService.getAnswer(1);
        assertEquals("some answer",answer.getAnswer());
        assertEquals(true,answer.getCorrect());
    }

    @Test
    public void getAllAnswerByQuestionId() throws Exception {
        List<Answer> answers = answerService.getAllAnswerByQuestionId(1);
        assertEquals(4,answers.size());
        assertEquals("someAnswer1",answers.get(0).getAnswer());

    }


    private static Answer dummyAnswer() {

        Answer testAnswer = new Answer();
        testAnswer.setAnswerId(1);
        testAnswer.setCorrect(true);
        testAnswer.setAnswer("some answer");
        testAnswer.setQuestionId(1);
        return testAnswer;
    }

    private static List<Answer> dummyAnswerList() {
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("someAnswer1",true,1));
        answerList.add(new Answer("someAnswer2",false,1));
        answerList.add(new Answer("someAnswer3",false,1));
        answerList.add(new Answer("someAnswer4",false,1));
        return answerList;
    }

}