package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Compaign;
import com.afaaq.afaaqdash.services.CompaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CompaignController {
    @Autowired
    private CompaignService compaignService;

    //create compaign API
    @PostMapping("/saveCompaign")
    public Compaign createCompaign(@RequestBody Compaign compaign) {
        System.out.println("Received admin: " + compaign);
        return compaignService.saveCompaign(compaign);
    }

    //Compaign deletion API
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCampaignByName(@PathVariable int id) {
        compaignService.deleteCompaignFct(id);
        return ResponseEntity.ok().body(Map.of("message", "Campaign deleted successfully !"));
    }
    /*public Compaign deleteCompaign(@PathVariable int id) {
        System.out.println("Received admin: " + id);
        Compaign deletedCompaign = compaignService.deleteCompaignFct(id);
        System.out.println("deleted successfully: " + id);
        return deletedCompaign;
    }*/
}
