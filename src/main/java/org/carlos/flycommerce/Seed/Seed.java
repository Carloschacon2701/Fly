package org.carlos.flycommerce.Seed;


import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.*;
import org.carlos.flycommerce.Repository.*;
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

    private final HotelRepository hotelRepository;

    private final RoomTypeRepository roomTypeRepository;

    private final RoomRepository roomRepository;

    private final CountryRepository countryRepository;

    private final CityRepository cityRepository;

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

    private final Map<Integer, Country> countries = Map.of(
            1, Country.builder()
                    .name("Costa Rica")
                    .build(),
            2, Country.builder()
                    .name("Panama")
                    .build()
    );

    private final Map<Integer, City> cities = Map.of(
            1, City.builder()
                    .name("San Jose")
                    .country(countries.get(1))
                    .build(),
            2, City.builder()
                    .name("Panama City")
                    .country(countries.get(2))
                    .build()
    );

    private final Map<Integer, Hotel> hotels = Map.of(
            1, Hotel.builder()
                    .name("Hotel 1")
                    .address("Address 1")
                    .city(cities.get(1))
                    .address("Address 1")
                    .stars(5)
                    .phone("12345678")
                    .build(),
            2, Hotel.builder()
                    .name("Hotel 2")
                    .address("Address 2")
                    .city(cities.get(2))
                    .address("Address 2")
                    .stars(5)
                    .phone("12345678")
                    .build()
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

            countries.forEach((id, country) -> {
                countryRepository.save(country);
                System.out.println("Country " + country.getName() + " saved");
            });

            cities.forEach((id, city) -> {
                cityRepository.save(city);
                System.out.println("City " + city.getName() + " saved");
            });

            hotels.forEach((id, hotel) -> {
                hotelRepository.save(hotel);
                System.out.println("Hotel " + hotel.getName() + " saved");
            });

            System.out.println("Data seeded");

        };
    }
}
