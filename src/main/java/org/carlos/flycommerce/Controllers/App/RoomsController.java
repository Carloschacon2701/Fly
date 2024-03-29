package org.carlos.flycommerce.Controllers.App;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.MySql.Room;
import org.carlos.flycommerce.Services.App.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomService roomService;

    @GetMapping("/hotel/{hotel_id}")
    public ResponseEntity<List<Room>> getRoomByHotel(
            @PathVariable Integer hotel_id
    ) {
        try{
            return ResponseEntity.ok(roomService.getRoomByHotel(hotel_id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(roomService.getRoom(id));
    }


}
