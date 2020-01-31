package com.arvato.exercise.latifi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * A test class to test the exercise 02.
 * To test this exercise the json data of the sampleProductsData.json will be sent
 * to the api and the response will be compared with the expected response!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx02 {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private String requestURL = "/text/analyze";

    private MockMvc mockMvc;

    public TestEx02() throws IOException {}

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * The test method that sends a post request to text/analyze and
     * first checks the response code and then compares the response with the expected value!
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        String content = fileToString("arvato/sampleProductsData.json"); // Sending content

        // Sending the query as a POST request
        MvcResult mvcResult = mockMvc.perform(post(requestURL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String expectedResponse =
                "{\"mostExpensiveProduct\":\"product82\",\"cheapestProduct\":\"product7\"," +
                        "\"mostPopularProduct\":\"product10\",\"germanProducts\":[\"product8\",\"product28\"," +
                        "\"product2\"],\"chineseProducts\":[\"product41\"],\"containsFragileProducts\":true}";

        String response = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedResponse, response);
    }

    public String fileToString(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        return new String(data);
    }

}
