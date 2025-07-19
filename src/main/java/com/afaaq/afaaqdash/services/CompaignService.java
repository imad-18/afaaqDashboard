package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Compaign;
import com.afaaq.afaaqdash.repository.CompaignRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompaignService {
    @Autowired
    private CompaignRepo compaignRepo;

    //create compaign
    public Compaign saveCompaign(Compaign compaign) {
        return compaignRepo.save(compaign);
    }

    public Optional<Compaign> findCompaignById(int id){
        return compaignRepo.findById(id);
    }

    public Compaign deleteCompaignFct(int id){
        Compaign compaign = findCompaignById(id).get();
        compaignRepo.delete(compaign);
        return compaign;
    }
    /*public Compaign deleteCompaignFct(int id) {
        Optional<Compaign> optionalCompaign = compaignRepo.findById(id);
        if (optionalCompaign.isPresent()) {
            Compaign compaign = optionalCompaign.get();
            compaignRepo.delete(compaign);
            return compaign;
        } else {
            throw new EntityNotFoundException("Compaign not found with id: " + id);
        }
    }*/

}
