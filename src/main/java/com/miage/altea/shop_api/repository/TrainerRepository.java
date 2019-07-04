package com.miage.altea.shop_api.repository;


import com.miage.altea.shop_api.bo.Trainer;

import java.util.List;

public interface TrainerRepository {
    List finAllTrainers();
    Trainer findTrainerById(int id);
    Trainer findTrainerByName(String name);
    void save(Trainer trainer);
}