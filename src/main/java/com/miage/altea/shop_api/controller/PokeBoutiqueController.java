package com.miage.altea.shop_api.controller;


import com.miage.altea.shop_api.service.PokeBoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Controller

public class PokeBoutiqueController {

    @GetMapping(value = "/shop")
    public String pokeBoutique() {
        return "pokeBoutique";
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
