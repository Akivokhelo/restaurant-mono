package hu.obuda.akosszanto.restaurant.model.repository;

import hu.obuda.akosszanto.restaurant.model.Reservation;
import hu.obuda.akosszanto.restaurant.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByFromDateAfterAndEndsDateBefore(Timestamp from, Timestamp to);

}
