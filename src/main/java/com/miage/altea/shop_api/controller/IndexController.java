package com.miage.altea.shop_api.controller;
import com.miage.altea.shop_api.bo.Trainer;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    /**
    @GetMapping(value = "/")
    public ModelAndView shop() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Map<String, Object> stringObjectMap = new HashMap<>();
        Trainer trainer = this.trainerService.findTrainerByName(principal.getUsername());
        stringObjectMap.put("trainer", trainer);
        return new ModelAndView("shop", stringObjectMap);
    }
**/
}