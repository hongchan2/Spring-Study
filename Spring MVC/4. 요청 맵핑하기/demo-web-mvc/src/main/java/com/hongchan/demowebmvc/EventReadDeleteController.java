package com.hongchan.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventReadDeleteController {

    @GetMapping("/events")
    public @ResponseBody String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    public @ResponseBody String getAnEvents(@PathVariable int id) {
        return "getAnEvents " + id;
    }

    @DeleteMapping("/events/{id}")
    public @ResponseBody String removeAnEvents(@PathVariable int id) {
        return "removeAnEvents " + id;
    }

}
