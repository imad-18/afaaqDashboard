package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Activity;
import com.afaaq.afaaqdash.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    // create new activity
    @PostMapping("/activity")
    public Activity createActivity(@RequestBody Activity activity) {
        System.out.println("Activity created");
        return activityService.saveActivity(activity);
    }
}
