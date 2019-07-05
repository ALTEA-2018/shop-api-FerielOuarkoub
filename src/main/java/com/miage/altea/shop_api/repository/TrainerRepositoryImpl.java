package com.miage.altea.shop_api.repository;

import com.miage.altea.shop_api.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.miage.altea.shop_api.bo.Object;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepositoryImpl implements TrainerRepository {
    private List<Trainer> trainers;

    private ObjectRepository objectRepository;

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

    @Override
    public boolean addObject(int idObject, String name) {

        var trainer = this.trainers.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        var object = this.objectRepository.findObjectId(idObject);
        if ((trainer.getPokeMoney() < object.getPrice() ) && (object.getStock() <= 0)) {
            return false;

        }
        var currentBag = trainer.getBag();
        var newBag = new ArrayList<>(currentBag);
        var newObject = new Object(object.getType());
        newBag.add(newObject);
        trainer.setBag(newBag);
        trainer.setPokeMoney(trainer.getPokeMoney() - object.getPrice());
        object.setStock(object.getStock() - 1);

        return true;
    }

    @Autowired
    public void setObjectRepository(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }
}