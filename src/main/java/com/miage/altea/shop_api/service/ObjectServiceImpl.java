package com.miage.altea.shop_api.service;

import com.miage.altea.shop_api.bo.Object;
import com.miage.altea.shop_api.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    private ObjectRepository objectRepository;


    @Override
    public Object findObjectId(int id) {
        return null;
    }

    @Override
    public Object findObjectByName(String name) {
        return null;
    }

    @Override
    public List<Object> findAllObject() {
        return this.objectRepository.findAllObject();
    }


    @Autowired
    public void setObjectRepository(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }
}
