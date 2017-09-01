package com.my.test.impl;

import com.my.test.inter.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

    public void play() {
        String title = "Sgt. Pepper's Lonely Hearts Club Band";
        String artist = "The Beatles";
        System.out.println("Playing " + title + " by " + artist);
    }

}
