package com.miage.altea.shop_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import com.miage.altea.shop_api.bo.Object;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ObjectRepositoryImpl implements ObjectRepository {

    private List<Object> objects;

    public ObjectRepositoryImpl () {

        try {
            var objectsStream = new ClassPathResource("objects.json").getInputStream();
            var objectMapper = new ObjectMapper();
            var itemsArray = objectMapper.readValue(objectsStream, Object[].class);
            this.objects = Arrays.asList(itemsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
        return this.objects;
    }



}


