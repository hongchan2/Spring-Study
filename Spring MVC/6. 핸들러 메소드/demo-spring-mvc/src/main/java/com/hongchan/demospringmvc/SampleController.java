package com.hongchan.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class SampleController {

    private List<Event> eventList = new ArrayList<>();

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        model.addAttribute("event", new Event());
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFromNameSumit(@Valid @ModelAttribute Event event,
                                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "events/form-name";
        }
        return "redirect:/events/form/id";
    }

    @GetMapping("/events/form/id")
    public String eventsFormId(@ModelAttribute Event event,
                               Model model) {
        model.addAttribute(event);
        return "/events/form-id";
    }

    @PostMapping("/events/form/id")
    public String eventFormIdSubmit(@Valid @ModelAttribute Event event,
                                    BindingResult bindingResult,
                                    SessionStatus sessionStatus,
                                    RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "/events/form-id";
        }

        // Store to Database
        eventList.add(event);
        sessionStatus.setComplete();

        redirectAttributes.addFlashAttribute(event);
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String showEvents(Model model, @SessionAttribute LocalDateTime visitTime) {
        System.out.println(visitTime);

        // Select from database
        model.addAttribute(eventList);
        return "/events/list";
    }
}
