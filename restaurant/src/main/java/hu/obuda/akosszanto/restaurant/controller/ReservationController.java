package hu.obuda.akosszanto.restaurant.controller;

import hu.obuda.akosszanto.restaurant.model.Reservation;
import hu.obuda.akosszanto.restaurant.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/reserve")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/all")
    @Operation(summary = "Get all reservations",
            description = "Get all reservations",
            tags = {"reservation"},
            operationId = "getAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }


    @PostMapping("/make")
    @Operation(summary = "Make a reservation",
            description = "Make a reservation",
            tags = {"reservation"},
            operationId = "makeReservation")
    public Reservation makeReservation(@RequestBody Reservation reservation) {
        return reservationService.makeReservation(reservation);
    }
}
