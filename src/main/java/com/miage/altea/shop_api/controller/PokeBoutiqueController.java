package com.miage.altea.shop_api.controller;



import com.miage.altea.shop_api.bo.Trainer;
import com.miage.altea.shop_api.service.ObjectService;
import com.miage.altea.shop_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miage.altea.shop_api.bo.Object;


@Controller

public class PokeBoutiqueController {

    private ObjectService objectService;
    private TrainerService trainerService;




    @GetMapping(value = "/shop")
    public ModelAndView pokeBoutique() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        List<Object> objects = this.objectService.findAllObject();
        Map<String, java.lang.Object> map = new HashMap<>();
        map.put("trainer",trainer);
        map.put("objects",objects);


        return new ModelAndView("pokeBoutique",map);


    }


    @PostMapping(value = "/addObject")
    public ModelAndView buyObject(int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Map<String, java.lang.Object> map = new HashMap<>();

        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        boolean canBuy = this.trainerService.addObject(id, trainer.getName());

        List<Object> objects = this.objectService.findAllObject();
        if (canBuy) {
            map.put("message", "Il est a vous ! ");
        } else {
            map.put("message", "Oups pas assez d'argent !! ");
        }
        map.put("trainer", trainer);
        map.put("objects", objects);
        return new ModelAndView("pokeBoutique", map);
    }



    @Autowired
    public void setObjectService(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


}
