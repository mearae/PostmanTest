package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.demo.user.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

// http://localhost:8080 로 시작할 수 있도록 셋팅.
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends MyRestDoc{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testJoin() throws Exception{
        // given
        UserRequest.JoinDto joinDto = new UserRequest.JoinDto();

        joinDto.setEmail("example123@gmail.com");
        joinDto.setPassword("asdfasd123!");
        joinDto.setName("배준혁");

        String requestBody = objectMapper.writeValueAsString(joinDto);

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/join")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON_VALUE));

        // verify
        resultActions.andExpect(jsonPath("$.success").value("true"));
        resultActions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    @Sql("classpath:db/dataset.sql")
    public void testLogin() throws Exception{
        // given
        UserRequest.JoinDto joinDto = new UserRequest.JoinDto();

        joinDto.setEmail("example123@gmail.com");
        joinDto.setPassword("asdfasd123!");
        joinDto.setName("배준혁");

        String requestBody = objectMapper.writeValueAsString(joinDto);

        // when
        ResultActions resultActions = mockMvc.perform(
                        post("/login")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON_VALUE));

        // verify
        resultActions.andExpect(jsonPath("$.success").value("true"));
        resultActions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

}
