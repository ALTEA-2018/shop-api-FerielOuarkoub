package com.miage.altea.shop_api.service;


import com.miage.altea.shop_api.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List findAllTrainers();
    Trainer findTrainerById(int id);
    Trainer findTrainerByName(String name);
    void addMoney(int qteMoney, String name);

}