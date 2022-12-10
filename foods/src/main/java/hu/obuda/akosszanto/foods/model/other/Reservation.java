package hu.obuda.akosszanto.foods.model.other;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {

    private Long id;

    private String name;

    private Timestamp fromDate;

    private Timestamp endsDate;

    private Integer numberOfPeople;

}
