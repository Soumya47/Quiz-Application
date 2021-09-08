package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Answer;
import com.greenapex.quizApp.services.AnswerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    @Test
    public void addAnswer_test() throws Exception {
        String json = "{\n"+
                "\"answer\": \"some answer\",\n"+
                "\"correct\": true,\n"+
                "\"questionId\": 1\n"+
                "}";
        Answer answer = new Answer("some answer",true,1);
        Mockito.when(answerService.addAndUpdateAnswer(Mockito.any(Answer.class))).thenReturn(answer);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ans")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Answer added successfully"+ content);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }


    @Test
    public void getAnswer_test() throws Exception {

        Mockito.when(answerService.getAnswer(Mockito.anyInt())).thenReturn(
                new Answer ("Some Answer",true,1));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/ans/1")).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("Success"+contentAsString);
        assert (contentAsString.isEmpty() == false);

    }

    @Test
    public void getAnswerByQuestionId_test() throws Exception {
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("someAnswer1",true,1));
        answerList.add(new Answer("someAnswer2",false,1));
        answerList.add(new Answer("someAnswer3",false,1));
        answerList.add(new Answer("someAnswer4",false,1));

        Mockito.when(answerService.getAllAnswerByQuestionId(Mockito.anyInt())).thenReturn(answerList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/ansques/1")).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("Success"+contentAsString);
        assert (contentAsString.isEmpty() == false);
    }


}