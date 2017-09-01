package com.my.test.config;

import com.my.test.service.MediaPlayer;
import com.my.test.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.my.test"})
public class CDPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(){
        MediaPlayer player = new MediaPlayer();
        return player;
    }
}
