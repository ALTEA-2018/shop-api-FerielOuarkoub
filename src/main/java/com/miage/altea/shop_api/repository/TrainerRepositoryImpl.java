package com.miage.altea.shop_api.repository;

import com.miage.altea.shop_api.bo.Trainer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepositoryImpl implements TrainerRepository {
    private List<Trainer> trainers;

    public TrainerRepositoryImpl() {
        this.trainers = new ArrayList<>();
    }

    @Override
    public List finAllTrainers() {
        return this.trainers;
    }

    @Override
    public Trainer findTrainerById(int id) {
        return this.trainers.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Trainer findTrainerByName(String name) {
        return this.trainers.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void save(Trainer trainer) {
        this.trainers.add(trainer);
    }

    @Override
    public void addMoney(int qteMoney, String name) {
        var trainer = this.findTrainerByName(name);
         trainer.setPokeMoney(trainer.getPokeMoney()+ qteMoney * 1000);
    }


}