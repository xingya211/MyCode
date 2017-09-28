package com.my.test.service;

import com.my.test.impl.SgtPeppers;
import com.my.test.inter.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MediaPlayer implements CompactDisc {

    private String whoAmI;

    private SgtPeppers sgtPeppers;

    public void play() {

        System.out.println("I am " + whoAmI);
        sgtPeppers.play();
    }

    @Autowired
    public void setSgtPeppers(SgtPeppers sgtPeppers) {
        this.sgtPeppers = sgtPeppers;
    }

    public String getWhoAmI() {
        return whoAmI;
    }

    public void setWhoAmI(String whoAmI) {
        this.whoAmI = whoAmI;
    }
}
