package hu.obuda.akosszanto.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@javax.persistence.Table(name = "RESERVATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Timestamp fromDate;

    private Timestamp endsDate;

    private Integer numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;
}
