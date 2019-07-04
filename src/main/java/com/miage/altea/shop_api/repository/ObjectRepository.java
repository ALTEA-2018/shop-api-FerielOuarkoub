package com.miage.altea.shop_api.repository;
import com.miage.altea.shop_api.bo.Object;

import java.util.List;

public interface ObjectRepository {
    Object findObjectId(int id);
    Object findObjectByName(String name);
    List<Object> findAllObject();

}
