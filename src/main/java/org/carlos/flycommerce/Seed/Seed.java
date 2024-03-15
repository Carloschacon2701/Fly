package org.carlos.flycommerce.Seed;


import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.Gender;
import org.carlos.flycommerce.Models.Role;
import org.carlos.flycommerce.Models.User;
import org.carlos.flycommerce.Repository.GenderRepository;
import org.carlos.flycommerce.Repository.RoleRepository;
import org.carlos.flycommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Seed {

    private final UserRepository userRepository;

    private final GenderRepository genderRepository;

    private final RoleRepository roleRepository;

    private final Map<Integer, Gender> genders = Map.of(
            1, Gender.builder()
                    .name("male")
                    .build(),
            2, Gender.builder()
                    .name("female")
                    .build()
    );

    private final Map<Integer, Role> roles = Map.of(
            1, Role.builder()
                    .name("admin")
                    .build(),
            2, Role.builder()
                    .name("client")
                    .build()
    );

    private final Map<Integer, User> users = Map.of(
            1, User.builder()
                    .email("Carloschacon@yopmail.com")
                    .username("Carlos")
                    .dateOfBirth(new Date())
                    .role(roles.get(1))
                    .gender(genders.get(1)).build(),

            2, User.builder()
                    .email("gabriela@yopmail.com")
                    .username("Gabriela")
                    .dateOfBirth(new Date())
                    .role(roles.get(2))
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

            roles.forEach((id, role) -> {
                roleRepository.save(role);
                System.out.println("Role " + role.getName() + " saved");
            });

            users.forEach((id, user) -> {
                userRepository.save(user);

                System.out.println("User " + user.getEmail() + " saved");
            });

        };
    }
}
