package com.wawcode.smogue.application;

import com.wawcode.smogue.domain.api.SubscriberDto;
import com.wawcode.smogue.domain.api.SubscriberService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public @ResponseBody
    String getBookDetails() {
        return "ready";
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerSubscriber(@RequestBody SubscriberDto subscriber) throws EmailException, MalformedURLException {
        subscriberService.sendConfirmationEmail(subscriber);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/email-confirmed")
    public ResponseEntity sendFirstSmsNewsletter(@RequestParam String email){
        subscriberService.sendSmsNewsletter(email);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
