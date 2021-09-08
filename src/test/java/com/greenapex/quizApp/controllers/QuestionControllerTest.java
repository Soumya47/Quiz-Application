package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.Question;
import com.greenapex.quizApp.services.QuestionService;
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

@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @Test
    public void addQuestion_test() throws Exception {
        String json = "{"+"\"questionId\":1,"+"\"question\":\"some question ?\","+ "\"quizId\":1"+"}";
        Question question = new Question(1,"some question ?",1);
        Mockito.when(questionService.addAndUpdateQuestion(Mockito.any(Question.class))).thenReturn(question);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ques")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Question added successfully"+ content);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
        assertEquals(json,content);
    }
    @Test
    public void test_getQuestion() throws Exception {
        Mockito.when(questionService.getQuestion(Mockito.anyInt()))
                .thenReturn(new Question(1,"some question ?",1));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/ques/1")).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("Success"+contentAsString);
        assert (contentAsString.isEmpty() == false);
    }

    @Test
    public void test_getQuestionByQuizId() throws Exception {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(1,"Some question1 ?",1));
        questionList.add(new Question(2,"some question2 ?",1));
        questionList.add(new Question(3,"some question3 ?",1));

        Mockito.when(questionService.getAllQuestionByQuizId(Mockito.any())).thenReturn(questionList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/quesquiz/1")).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("Success "+ contentAsString);
        assert (contentAsString.isEmpty() == false);
    }
}























