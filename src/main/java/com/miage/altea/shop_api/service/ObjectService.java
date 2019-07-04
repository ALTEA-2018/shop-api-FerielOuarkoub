package com.miage.altea.shop_api.service;

import com.miage.altea.shop_api.bo.Object;

import java.util.List;

public interface ObjectService {

    Object findObjectId(int id);
    Object findObjectByName(String name);
    List<Object> findAllObject();

}
