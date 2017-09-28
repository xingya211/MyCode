package com.my.test.service.itf;

import com.my.test.dto.Spitter;

public interface SpitterRepository {

    void save(Spitter spitter);
    Spitter findByUserName(String userName);
}
