package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Activity;
import com.afaaq.afaaqdash.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    // Delete activity
    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Map<String, String>> deleteActivityById(@PathVariable int id) {
        System.out.println("Activity deleted");
        activityService.deleteActivityByIdFct(id);
        return ResponseEntity.ok().body(Map.of("message", "Activity deleted successfully !"));
    }

    // Update activity
    @PutMapping("/activity/update/{id}")
    public ResponseEntity<Map<String, String>> updateActivityById(@PathVariable int id, @RequestBody Activity activity) {
        System.out.println("Activity updated");
        activityService.updateActivityFct(activity);
        return ResponseEntity.ok().body(Map.of("message", "Activity with %s updated successfully !".formatted(id)));
    }

}
