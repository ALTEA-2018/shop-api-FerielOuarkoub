package com.miage.altea.shop_api.service;


import com.miage.altea.shop_api.bo.Trainer;
import com.miage.altea.shop_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    public TrainerRepository trainerRepository;

    @Override
    public List findAllTrainers() {
        return this.trainerRepository.finAllTrainers();
    }

    @Override
    public Trainer findTrainerById(int id) {
        return this.trainerRepository.findTrainerById(id);
    }

    @Override
    public Trainer findTrainerByName(String name) {
        return this.trainerRepository.findTrainerByName(name);
    }

    public TrainerRepository getTrainerRepository() {
        return trainerRepository;
    }

    @Override
    public void addMoney(int qteMoney, String name) {
        this.trainerRepository.addMoney(qteMoney,name);
    }

    @Override
    public boolean addObject(int idObject, String name) {
        return this.trainerRepository.addObject(idObject, name);
    }


    @Autowired
    public void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

}