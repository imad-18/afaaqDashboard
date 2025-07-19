package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Compaign;
import com.afaaq.afaaqdash.services.CompaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaignController {
    @Autowired
    private CompaignService compaignService;

    //create compaign
    @PostMapping("/saveCompaign")
    public Compaign createCompaign(@RequestBody Compaign compaign) {
        System.out.println("Received admin: " + compaign);
        return compaignService.saveCompaign(compaign);
    }
}
