package kr.ac.kw.hong.example2;

import org.springframework.lang.NonNull;

public class Example {

    @NonNull
    public String createName(@NonNull String name){
        return "Hello " + name;
    }
}
