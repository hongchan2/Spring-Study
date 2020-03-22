package com.hongchan.demojsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @GetMapping("/events")
    public String getEvents(Model model) {
        Event event1 = new Event();
        event1.setName("Spring MVC Study 1");
        event1.setStarts(LocalDateTime.of(2019, 1, 15, 10, 0));

        Event event2 = new Event();
        event1.setName("Spring MVC Study 2");
        event1.setStarts(LocalDateTime.of(2019, 1, 16, 10, 0));

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        model.addAttribute("events", events);
        model.addAttribute("message", "Hello Spring!");

        return "events/list";
    }
}
