package com.miage.altea.shop_api.controller;

import com.miage.altea.shop_api.bo.Trainer;
import com.miage.altea.shop_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
    public class PokeSacController {

    private TrainerService trainerService;

        @GetMapping(value = "/sac")
        public ModelAndView pokeSac() {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
            Map<String, Object> map = new HashMap<>();
            map.put("trainer",trainer);
            return new ModelAndView("pokeSac",map);
        }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}

