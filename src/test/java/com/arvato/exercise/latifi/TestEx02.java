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

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx02 {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Utility utility;

    private String requestURL = "/text/analyze";

    private MockMvc mockMvc;

    public TestEx02() throws IOException {
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        String content = utility.fileToString("arvato/sampleProductsData.json");

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

}
