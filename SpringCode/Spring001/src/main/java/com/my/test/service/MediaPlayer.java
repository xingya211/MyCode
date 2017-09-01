package com.my.test.service;

import com.my.test.impl.SgtPeppers;
import com.my.test.inter.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MediaPlayer implements CompactDisc {

    private SgtPeppers sgtPeppers;

    public void play() {

        sgtPeppers.play();
    }

    @Autowired
    public void setSgtPeppers(SgtPeppers sgtPeppers) {
        this.sgtPeppers = sgtPeppers;
    }

    public SgtPeppers getSgtPeppers() {
        return sgtPeppers;
    }
}
