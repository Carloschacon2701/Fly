package org.carlos.flycommerce.Services.App;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.MySql.Room;
import org.carlos.flycommerce.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Room getRoom(Integer id) {
        return roomRepository.findById(id).orElseThrow();
    }

    public List<Room> getRoomByHotel(Integer hotel_id) {
        return roomRepository.findAllByHotel_Id(hotel_id).orElseThrow();
    }


}
