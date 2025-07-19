package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Compaign;
import com.afaaq.afaaqdash.repository.CompaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaignService {
    @Autowired
    private CompaignRepo compaignRepo;

    //create compaign
    public Compaign saveCompaign(Compaign compaign) {
        return compaignRepo.save(compaign);
    }
}
