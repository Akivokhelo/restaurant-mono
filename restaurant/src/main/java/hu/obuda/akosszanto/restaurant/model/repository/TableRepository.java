package hu.obuda.akosszanto.restaurant.model.repository;

import hu.obuda.akosszanto.restaurant.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> findAllByWinterReady(Boolean winterReady);

}
