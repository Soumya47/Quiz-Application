package com.greenapex.quizApp.services;

import com.greenapex.quizApp.repositories.AssessmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.*;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AssessmentServiceTest {

    @Mock
    AssessmentRepository assessmentRepository;

    @InjectMocks
    private static AssessmentService assessmentService;

    @BeforeEach
    public void setUp() {
        Mockito.when(assessmentRepository.getAllResultOfAUser(Mockito.any())).thenReturn(dummyAssessmentListOfUser());
        Mockito.when(assessmentRepository.getResultsByUserIdAndQuizId(Mockito.any(),Mockito.any())).thenReturn(dummyAssessmentListOfUser());
    }

    @Test
    public void getAllResultOfAUser() throws Exception {
        List<Map<String,Object>> list = assessmentService.getAllResultOfAUser(1);
        assert (list.isEmpty()==false);
        assertTrue(list.size()==2);
        assertEquals("some question ?",list.get(0).get("question"));
    }

    @Test
    public void getAllResultByUserAndQuiz() throws Exception {
        Integer userId = 1;
        Integer quizId = 1;
        List<Map<String,Object>> list = assessmentService.getAllResultByUserAndQuiz(userId,quizId);
        assertEquals(true,list.get(quizId-1).get("username")=="soumya47" && list.get(quizId-1).get("quiz_id")==(Object) 1);
        assertEquals("some question2 ?",list.get(quizId).get("question"));
    }

    private static List<Map<String,Object>> dummyAssessmentListOfUser() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();

        map1.put("quiz_id",1);

        map1.put("question","some question ?");

        map1.put("username","soumya47");

        map1.put("answer","some answer");

        map1.put("is_correct",true);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("quiz_id",2);

        map2.put("question","some question2 ?");

        map2.put("username","soumya47");

        map2.put("answer","some answer2");

        map2.put("is_correct",false);
        mapList.add(map1);
        mapList.add(map2);
        return mapList;
    }
}