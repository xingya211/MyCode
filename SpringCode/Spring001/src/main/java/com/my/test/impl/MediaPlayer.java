package com.my.test.impl;

import com.my.test.inter.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MediaPlayer implements CompactDisc {

    private SgtPeppers sgtPeppers;

    public void play() {
        System.out.println("MediaPlayer Playing");
    }

    @Autowired
    public void setSgtPeppers(SgtPeppers sgtPeppers) {
        this.sgtPeppers = sgtPeppers;
    }

    public SgtPeppers getSgtPeppers() {
        return sgtPeppers;
    }
}
