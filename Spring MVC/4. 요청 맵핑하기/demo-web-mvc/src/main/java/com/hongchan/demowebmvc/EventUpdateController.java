package com.hongchan.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class EventUpdateController {

    @PostMapping("/events")
    public @ResponseBody String createEvent() {
        return "createEvent";
    }

    @PutMapping("/events/{id}")
    public @ResponseBody String updateEvent(@PathVariable int id) {
        return "updateEvent";
    }
}
