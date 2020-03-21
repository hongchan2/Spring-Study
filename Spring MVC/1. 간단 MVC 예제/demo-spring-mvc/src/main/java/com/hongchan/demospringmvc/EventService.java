package com.hongchan.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("Spring Study 1")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 1, 10, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 1, 10, 12, 0))
                .build();

        Event event2 = Event.builder ()
                .name("Spring Study 2")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 1, 17, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 1, 17, 12, 0))
                .build();

        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);

        return eventList;
    }
}
