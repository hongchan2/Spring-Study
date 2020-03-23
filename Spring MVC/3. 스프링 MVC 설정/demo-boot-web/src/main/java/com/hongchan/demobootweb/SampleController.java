package com.hongchan.demobootweb;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message(@RequestBody String str) {
        return str;
    }

    @GetMapping("/jsonmessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }
}
