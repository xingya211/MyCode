package com.my.test.controller;

import com.my.test.dto.Spittle;
import com.my.test.service.itf.SpittleRepository;
import com.my.test.springconfig.RootConfig;
import com.my.test.springconfig.SpittrWebAppInitializer;
import com.my.test.springconfig.WebConfig;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class SpittleControllerTest {

    private SpittrWebAppInitializer spittleWebAppInitializer = new SpittrWebAppInitializer();
    private MockMvc mockMvc;

    @Test
    public void testSpittles() throws Exception {

        List<Spittle> expectedSpitles = createSpittleList(20);
        SpittleRepository mockSpittleRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockSpittleRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpitles);

        SpittleController spittleController = new SpittleController(mockSpittleRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(spittleController).build();
        mockMvc.perform(get("/spittle/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", IsCollectionContaining.hasItem(expectedSpitles)));

    }

    @Test
    public void testSpittle() throws Exception {

        Spittle spittle = new Spittle(new Long(1), new Date(), "Spittle1");
        SpittleRepository mockSpittleRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockSpittleRepository.findById("1")).thenReturn(spittle);

        SpittleController spittleController = new SpittleController(mockSpittleRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(spittleController).build();
        mockMvc.perform(get("/spittle/1"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"));

    }

    public List<Spittle> createSpittleList(int count) {

        List<Spittle> spittleList = new ArrayList<Spittle>();

        for (int i = 0; i < count; i++) {
            spittleList.add(new Spittle(Long.parseLong("" + i), new Date(), "Spittle" + i));
        }
        return spittleList;
    }
}
