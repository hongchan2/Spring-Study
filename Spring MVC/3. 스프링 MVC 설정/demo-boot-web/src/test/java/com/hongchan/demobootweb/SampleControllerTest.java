package com.hongchan.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void json() throws Exception {
        Person person = new Person();
        person.setName("hongchan");
        person.setId(25l);

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonmessage")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("hongchan");
        personRepository.save(person);

        mockMvc.perform(get("/hello")
                .param("id", "1"))
            .andDo(print())
            .andExpect(content().string("hello hongchan"));
    }

    @Test
    public void message() throws Exception {
        mockMvc.perform(get("/message")
                .content("hongchan"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}