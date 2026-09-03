package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void トップページ表示() throws Exception {
    MvcResult result = mockMvc.perform( get("/") )
    .andExpect( status().is2xxSuccessful() )
    .andExpect( content().string(containsString("Hello World")) )
    .andReturn();
    }

    @Test
    public void ハローページ表示() throws Exception {
    MvcResult result = mockMvc.perform( get("/hello") )
    .andExpect( status().is2xxSuccessful() )
    .andExpect( content().string(containsString("Hello, Spring Boot!")) )
    .andReturn();
    }
}
