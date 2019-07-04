package com.miage.altea.shop_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class PokePanierController {
        @GetMapping(value = "/sac")
        public String pokeSac() {
            return "pokeSac";
        }

    }

