package com.miage.altea.shop_api;

import com.miage.altea.shop_api.bo.Trainer;
//import com.miage.altea.shop_api.repository.TrainerRepository;
import com.miage.altea.shop_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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

            mojito.setPassword(bCryptPasswordEncoder.encode("rhum"));

            mojito.setPokeMoney(500);
            // save a couple of trainers
            //repository.save(blublu);
            //repository.save(forest);
            repository.save(mojito);

        };


    }

}
