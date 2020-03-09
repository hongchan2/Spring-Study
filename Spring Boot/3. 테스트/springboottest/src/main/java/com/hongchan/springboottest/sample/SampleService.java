package com.hongchan.springboottest.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Value("${hongchan.name}")
    private String name;

    public String getName() {
        return name;
    }
}
