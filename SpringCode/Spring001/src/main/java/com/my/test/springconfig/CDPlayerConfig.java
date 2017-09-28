package com.my.test.springconfig;

import com.my.test.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.my.test"})
@PropertySource("classpath:\\com\\my\\test\\util\\config.properties")
public class CDPlayerConfig {

   /* private Environment env;

    @Bean
    public MediaPlayer mediaPlayer(){
        MediaPlayer player = new MediaPlayer();
        //player.setWhoAmI(env.getProperty("mediaPlayer.whoAmI"));
        player.setWhoAmI(env.getProperty("mediaPlayer.whoAmI", String.class));
        return player;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }*/

    @Bean
    public MediaPlayer mediaPlayer(@Value("${mediaPlayer.whoAmI}") String whoAmI){
        MediaPlayer player = new MediaPlayer();
        //player.setWhoAmI(env.getProperty("mediaPlayer.whoAmI"));
        player.setWhoAmI(whoAmI);
        return player;
    }

}
