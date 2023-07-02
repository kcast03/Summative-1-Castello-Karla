package com.company.summative.controller;

import com.company.summative.models.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordController.class)
public class WordControllerTest {

    //wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // objectMapper used to convert java objects to json
    private ObjectMapper mapper = new ObjectMapper();

    // list of words for testing
    private List<Definition> wordList;

    @BeforeEach
    public void setUp(){
        //nothing here
    }

    //testing Get /word
    @Test
    public void shouldReturnARandomWordAndItsDefinition() throws Exception{

        //ARRANGE
        //convert obj to json
        String outputJson = mapper.writeValueAsString(wordList);

        //ACT
        mockMvc.perform(get("/word"))  //get request
                .andDo(print())         //print result
                .andExpect(status().isOk());
    }
}
