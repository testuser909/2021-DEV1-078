package com.gametictactoe.tictactoe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void playGame() throws Exception {
        /**
         *
         * The request body is:
         * {
         *     "player": X,
         *     "rowPosition": 1,
         *     "columnPosition": 2
         * }
         */
        String json = "{\"player\": 1, \"rowPosition\": \"1\", \"columnPosition\": \"1\"}";

        mockMvc.perform(
                post("/game/play")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isOk());    
    
    }
}
