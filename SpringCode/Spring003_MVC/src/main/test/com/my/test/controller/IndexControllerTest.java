package com.my.test.controller;

import com.my.test.springconfig.RootConfig;
import com.my.test.springconfig.SpittrWebAppInitializer;
import com.my.test.springconfig.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class IndexControllerTest {

    private SpittrWebAppInitializer spittrWebAppInitializer = new SpittrWebAppInitializer();
    private MockMvc mockMvc;

    @Test
    public void testIndex() {

        try {
            this.mockMvc = MockMvcBuilders.standaloneSetup(spittrWebAppInitializer).build();
            mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("index"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
