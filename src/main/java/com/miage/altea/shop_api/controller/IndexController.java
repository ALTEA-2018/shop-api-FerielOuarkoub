package com.miage.altea.shop_api.controller;

import com.miage.altea.shop_api.bo.Trainer;
import com.miage.altea.shop_api.service.TrainerService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    private List<Object> objects;

    private TrainerService trainerService;
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/auth")
    public ModelAndView shop() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Map<String, Object> stringObjectMap = new HashMap<>();
        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        stringObjectMap.put("trainer", trainer);
        return new ModelAndView("shop", stringObjectMap);
    }
}