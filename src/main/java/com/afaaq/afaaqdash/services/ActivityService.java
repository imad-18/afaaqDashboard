package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Activity;
import com.afaaq.afaaqdash.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired

    private ActivityRepo activityRepo;

    // save new activity
    public Activity saveActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    // delete activity
    public Activity deleteActivityByIdFct(int id) {
        Optional<Activity> activity = activityRepo.findById(id);
        activityRepo.delete(activity.get());
        return activity.get();
    }

    // Update Activity
    public Activity updateActivityFct(Activity activity) {
        Activity activity2 = activityRepo.findById(activity.getId()).get();

        activity2.setTitle(activity.getTitle());
        activity2.setDescription(activity.getDescription());
        activity2.setCategory(activity.getCategory());
        activity2.setFeedback(activity.getFeedback());
        activity2.setDuration(activity.getDuration());
        activity2.setEffective(activity.getEffective());
        activity2.setLaunchDate(activity.getLaunchDate());
        activity2.setLocation(activity.getLocation());
        activity2.setIconPath(activity.getIconPath());
        activity2.setGoals(activity.getGoals());
        activity2.setAlbums(activity.getAlbums());

        return activityRepo.save(activity2);
    }

    // Get all activities
    public List<Activity> getAllActivitiesFct() {
        return activityRepo.findAll();
    }

    // Get activity by title
    public List<Activity> getActivitiesByTitleFct(String title) {
        return activityRepo.findByTitle(title);
    }

    // Get activity by category
    public List<Activity> getActivitiesByCategoryFct(String category) {
        return activityRepo.findByCategory(category);
    }
}
