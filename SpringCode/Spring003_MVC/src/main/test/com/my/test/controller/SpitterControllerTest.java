package com.my.test.controller;

import com.my.test.dto.Spitter;
import com.my.test.service.itf.SpitterRepository;
import com.my.test.springconfig.RootConfig;
import com.my.test.springconfig.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class SpitterControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testProcessRegistration() throws Exception {
        SpitterRepository mockRespository = Mockito.mock(SpitterRepository.class);
        Spitter spitterSave = new Spitter(new Long(1), "user1", "111111");
        SpitterController spitterController = new SpitterController(mockRespository);
        mockMvc = MockMvcBuilders.standaloneSetup(spitterController).build();
        mockMvc.perform(post("/spitter/register")
                        .param("userName", "user1")
                        .param("password", "111111"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/user1"));

    }
}
