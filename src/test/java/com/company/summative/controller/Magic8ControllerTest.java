package com.company.summative.controller;

import com.company.summative.models.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Magic8Controller.class)
class Magic8ControllerTest {

    @Autowired
    private MockMvc mockMvc;


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
        question.setQuestion("Will Biden win re-election?");

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