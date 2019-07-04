package com.miage.altea.shop_api.controller;



import com.miage.altea.shop_api.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miage.altea.shop_api.bo.Object;


@Controller

public class PokeBoutiqueController {

    private ObjectService objectService;

    @GetMapping(value = "/shop")
    public ModelAndView pokeBoutique() {

        List<Object> objects = this.objectService.findAllObject();
        Map<String,java.lang.Object> map = new HashMap<>();
        map.put("objects",objects);
        return new ModelAndView("pokeBoutique",map);


    }




    @Autowired
    public void setObjectService(ObjectService objectService) {
        this.objectService = objectService;
    }

    //  private final PokeBoutiqueService pokeBoutiqueService;

    /**
    @Autowired
    PokeBoutiqueController(PokeBoutiqueService pokeBoutiqueService){
        this.pokeBoutiqueService = pokeBoutiqueService;
    }
    **/
/**
    @GetMapping( value = "/")
    Iterable<Object> getAllObjects(){
        return pokeBoutiqueService.getAllObjects();
    }

    @GetMapping(value = "/{name}")
    Object getObject(@PathVariable("name") String name){
        return pokeBoutiqueService.getObject(name);
    }
    **/

}
