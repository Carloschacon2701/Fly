package org.carlos.flycommerce.Services.App;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.DTO.Reservation.ReservationCreationDTO;
import org.carlos.flycommerce.Models.MySql.Reservation;
import org.carlos.flycommerce.Models.MySql.Room;
import org.carlos.flycommerce.Models.MySql.User;
import org.carlos.flycommerce.Repository.ReservationRepository;
import org.carlos.flycommerce.Repository.RoomRepository;
import org.carlos.flycommerce.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public Reservation getReservation(Integer id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public Reservation createReservation(ReservationCreationDTO reservation) {

        User user = userRepository.findById(reservation.getUser_id()).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        Room room = roomRepository.findById(reservation.getRoom_id()).orElseThrow(
            () -> new RuntimeException("Room not found")
        );

        Integer overLappingReservations = reservationRepository.countOverlappingReservations(
            reservation.getRoom_id(), reservation.getCheckIn(), reservation.getCheckOut()
        );

        if(overLappingReservations > room.getQuantity()){
            throw new RuntimeException("Room is not available for the selected dates");
        }

        Double total = room.getPrice() * reservation.getDays();


        return reservationRepository.save(
                Reservation.builder()
                        .days(reservation.getDays())
                        .checkIn(reservation.getCheckIn())
                        .checkOut(reservation.getCheckOut())
                        .adults(reservation.getAdults())
                        .children(reservation.getChildren())
                        .totalPrice(total)
                        .user(user)
                        .room(room)
                        .build()
        );
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }

}
