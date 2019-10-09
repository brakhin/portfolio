package ru.brakhin.receiver.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenReceiveCorrectDataThenRetriveOkStateAndNoErrorCode() throws Exception {
        String requestJson = getResourceFileContent("good_data.txt");
        MvcResult mvcResult = mockMvc.perform(post("/api/request/new").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk()).andReturn();
        String responce = mvcResult.getResponse().getContentAsString();
        assertThat(responce, is("{\"errorCode\":0,\"errorText\":null}"));
    }

    @Test
    public void whenReceiveIncorrectDataThenRetriveOkStateAndErrorCode() throws Exception {
        String requestJson = getResourceFileContent("bad_data.txt");
        MvcResult mvcResult = mockMvc.perform(post("/api/request/new").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk()).andReturn();
        String responce = mvcResult.getResponse().getContentAsString();
        assertThat(responce, is("{\"errorCode\":1,\"errorText\":[\"Не указана услуга\","
                + "\"Не указана фамилия\",\"Не указано имя\",\"Не указано отчество\",\"Не указана серия паспорта\","
                + "\"Не указан номер паспорта\",\"Не указано подразделение, выдавшее паспорт\","
                + "\"Не указан код подразделения, выдавшего паспорт\",\"Не указана дата выдачи паспорта\"]}"));
    }

    private String getResourceFileContent(String filename) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
}