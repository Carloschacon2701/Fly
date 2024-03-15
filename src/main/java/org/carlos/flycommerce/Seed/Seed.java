package org.carlos.flycommerce.Seed;


import org.carlos.flycommerce.Models.Gender;
import org.carlos.flycommerce.Models.User;
import org.carlos.flycommerce.Repository.GenderRepository;
import org.carlos.flycommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class Seed {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenderRepository genderRepository;

    private final Map<Integer, Gender> genders = Map.of(
            1, Gender.builder()
                    .name("male")
                    .build(),
            2, Gender.builder()
                    .name("female")
                    .build()
    );

    private final Map<Integer, User> users = Map.of(
            1, User.builder()
                    .email("Carloschacon@yopmail.com")
                    .username("Carlos")
                    .dateOfBirth(new Date())
                    .gender(genders.get(1)).build(),

            2, User.builder()
                    .email("gabriela@yopmail.com")
                    .username("Gabriela")
                    .dateOfBirth(new Date())
                    .gender(genders.get(2)).build()
    );

    @Bean
    CommandLineRunner seedData(){
        return args -> {
            System.out.println("Seeding data...");

            genders.forEach((id, gender) ->{
                genderRepository.save(gender);

                System.out.println("Gender " + gender.getName() + " saved");
            });

            users.forEach((id, user) -> {
                userRepository.save(user);

                System.out.println("User " + user.getEmail() + " saved");
            });

        };
    }
}
