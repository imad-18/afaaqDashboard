package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Activity;
import com.afaaq.afaaqdash.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired

    private ActivityRepo activityRepo;

    // save new activity
    public Activity saveActivity(Activity activity) {
        return activityRepo.save(activity);
    }
}
