package com.miage.altea.shop_api;

import com.miage.altea.shop_api.bo.Trainer;
import com.miage.altea.shop_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.miage.altea.shop_api.bo.Object;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);

    }


    @Bean
    @Autowired
    public CommandLineRunner demo(TrainerRepository repository) {

        return (args) -> {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            //var blublu = new Trainer("Blublu");

            //var forest = new Trainer("Forest");

            Trainer mojito = new Trainer("mojito");
            Object obj = new Object ("Potion");
            Object obj2 = new Object ("Rappel");
            obj.setId(22);
            obj2.setId(44);
            obj.setName("bananasplit");
            obj2.setName("help");
            obj.setPrice(300);
            obj2.setPrice(500);
            obj.setStock(10);
            obj2.setStock(20);
            obj.setImg("/images/rappel.jpg");
            obj2.setImg("/images/potion.jpg");
            mojito.setBag(Arrays.asList(obj,obj2));

            mojito.setPassword(bCryptPasswordEncoder.encode("rhum"));

            mojito.setPokeMoney(500);
            // save a couple of trainers
            //repository.save(blublu);
            //repository.save(forest);
            repository.save(mojito);

        };


    }

}
