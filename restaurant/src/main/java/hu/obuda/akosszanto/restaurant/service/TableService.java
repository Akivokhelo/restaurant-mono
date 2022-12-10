package hu.obuda.akosszanto.restaurant.service;
import hu.obuda.akosszanto.restaurant.model.Reservation;
import hu.obuda.akosszanto.restaurant.model.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import hu.obuda.akosszanto.restaurant.model.Table;
import hu.obuda.akosszanto.restaurant.model.repository.TableRepository;

@Service
@Slf4j
public class TableService {

    private final TableRepository tableRepository;
    private final ReservationRepository reservationRepository;

    public TableService(TableRepository tableRepository, ReservationRepository reservationRepository) {
        this.tableRepository = tableRepository;
        this.reservationRepository = reservationRepository;
    }


    public List<Table> getTables() {
       return tableRepository.findAll();
    }

    public List<Table> getTablesByWinterReady(Boolean winterReady) {
        log.info("Finding tables that are {} ready...", winterReady ? "winter/autumn" : "summer/spring");
        return tableRepository.findAllByWinterReady(winterReady);
    }

    public List<Table> getTablesAvailableAtTime(Timestamp from, Timestamp to) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(from.getTime());
        String fromTime = instance.toString();
        instance.setTimeInMillis(to.getTime());
        String toTime = instance.toString();
        log.info("Finding available time between {} and {}...",fromTime , toTime);
        List<Table> tables = tableRepository.findAll();
        List<Reservation> reservations = reservationRepository.findAllByFromDateAfterAndEndsDateBefore(from, to);
        tables.stream().filter(table -> reservations.stream().anyMatch(reservation -> reservation.getTable().getId().equals(table.getId()))).forEach(tables::remove);
        return tables;
    }
}
