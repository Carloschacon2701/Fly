package org.carlos.flycommerce.Services;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.City;
import org.carlos.flycommerce.Models.Hotel;
import org.carlos.flycommerce.Repository.CityRepository;
import org.carlos.flycommerce.Repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HotelService {
    private final CityRepository cityRepository;
    private final HotelRepository hotelRepository;

    public Hotel getHotel(Integer id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public List<Hotel> getHotelsByCity(Integer city_id) {
        return hotelRepository.findAllByCity_Id(city_id).orElseThrow();
    }

    public List<Hotel> getHotelsByCountry(Integer country_id) {
        return hotelRepository.findByCountry(country_id).orElseThrow();
    }

}
