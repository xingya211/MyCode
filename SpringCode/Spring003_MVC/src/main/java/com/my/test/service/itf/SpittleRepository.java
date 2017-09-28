package com.my.test.service.itf;

import com.my.test.dto.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);
    Spittle findById(String spittleId);

}
