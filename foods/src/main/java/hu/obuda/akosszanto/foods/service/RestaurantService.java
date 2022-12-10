package hu.obuda.akosszanto.foods.service;

import hu.obuda.akosszanto.foods.model.other.Reservation;
import hu.obuda.akosszanto.foods.model.other.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class RestaurantService {

    @Value("${restaurant.url:http://localhost:7180/}")
    private String restaurantUrl;

    private final RestTemplate restTemplate;

    public RestaurantService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void init() {

        if (restaurantUrl == null || restaurantUrl.isEmpty()) {
            throw new RuntimeException("Restaurant url is not set!");
        }


        log.info("Restaurant url: {}", restaurantUrl);

        if(getAllReservation().isEmpty()) {
            throw new RuntimeException("Restaurant is not available!");
        }
    }

    public List<Reservation> getAllReservation() {
        Reservation[] forObject = restTemplate.getForObject(restaurantUrl +
                "rest/v1/reserve/all", Reservation[].class);
        assert forObject != null;
        return List.of(forObject);
    }

    public List<Table> getAllTables() {
        Table[] forObject = restTemplate.getForObject(restaurantUrl +
                "rest/v1/table", Table[].class);
        assert forObject != null;
        return List.of(forObject);
    }


}
