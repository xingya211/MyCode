package com.my.test;

import com.my.test.config.CDPlayerConfig;
import com.my.test.impl.MediaPlayer;
import com.my.test.inter.CompactDisc;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule //基于控制台输出规则
    public final SystemOutRule log = new SystemOutRule().enableLog();

    private MediaPlayer player;

    @Test
    public void testPlay(){
        //assertNotNull(cd);
        player.getSgtPeppers().play();
        //assertEquals("Playing\r\n", log.getLog());//获取控制台输出与期望值对比
    }

    @Resource(name="mediaPlayer")
    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }
}
