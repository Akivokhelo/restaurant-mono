package hu.obuda.akosszanto.restaurant.service;

import hu.obuda.akosszanto.restaurant.model.Reservation;
import hu.obuda.akosszanto.restaurant.model.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation makeReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
