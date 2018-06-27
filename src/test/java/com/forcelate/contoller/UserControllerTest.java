package com.forcelate.contoller;


import com.forcelate.SpringBootJpaH2Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootJpaH2Application.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void findByAge() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greaterthan?age=26").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id", is(3)))
                .andExpect(jsonPath("$.[0].name",is("Ivan")))
                .andExpect(jsonPath("$.[0].age",is(30)))
                .andExpect(jsonPath("$.[1].id",is(4)))
                .andExpect(jsonPath("$.[1].name",is("Oleh")))
                .andExpect(jsonPath("$.[1].age",is(35)))
                .andExpect(jsonPath("$.[2].id",is(6)))
                .andExpect(jsonPath("$.[2].name",is("Roman")))
                .andExpect(jsonPath("$.[2].age",is(28)))
                .andDo(print());
    }





}