package com.example.dat250exercise5;

import com.example.dat250exercise5.ex3.GreetingController;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCount() throws Exception {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("id", GreetingController.counter.get() + 1);
        jsonResult.put("content", "Hello, World!");
        mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonResult.toString()));
    }

    @Test
    public void testParam() throws Exception {
        JSONObject jsonResult = new JSONObject();
        String param = "Ayoub Tammaoui";
        jsonResult.put("id", GreetingController.counter.get() + 1);
        jsonResult.put("content", "Hello, " + param + "!");
        mvc.perform(MockMvcRequestBuilders.get("/greeting?name="+ param).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonResult.toString()));
    }
}