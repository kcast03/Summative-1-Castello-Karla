package com.company.summative.controller;

import com.company.summative.models.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Magic8ControllerTest {




    private MockMvc mockMvc;

    @BeforeEach
    public  void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new Magic8Controller()).build();
    }

    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void shouldReturnAnswerWithoutQuestionRequestBody() throws  Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.post("/magic")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnAnswerWithQuestionRequestBody() throws  Exception{

        Question question = new Question();
        question.setQuestion("Will Biden win re-election");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/magic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(question))
                        .characterEncoding("utf-8")
                )

                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}