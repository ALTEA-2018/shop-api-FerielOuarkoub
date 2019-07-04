package com.miage.altea.shop_api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokeMoneyController {
    @GetMapping(value = "/money")
    public String pokeMoney() {
        return "pokeMoney";
    }

}
