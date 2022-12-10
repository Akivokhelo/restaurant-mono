package hu.obuda.akosszanto.foods.service;

import hu.obuda.akosszanto.foods.model.Food;
import hu.obuda.akosszanto.foods.model.TableFood;
import hu.obuda.akosszanto.foods.model.other.Reservation;
import hu.obuda.akosszanto.foods.model.other.Table;
import hu.obuda.akosszanto.foods.model.repository.FoodRepository;
import hu.obuda.akosszanto.foods.model.repository.TableFoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final TableFoodRepository tableFoodRepository;
    private final RestaurantService restaurantService;

    public FoodService(FoodRepository foodRepository, TableFoodRepository tableFoodRepository, RestaurantService restaurantService) {
        this.foodRepository = foodRepository;
        this.tableFoodRepository = tableFoodRepository;
        this.restaurantService = restaurantService;
    }


    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public List<TableFood> getFoodByTableId(Long tableId) {
        return tableFoodRepository.findFoodByTableId(tableId);
    }

    public List<TableFood> addFoodToTable(Long tableId, Long foodId) {
        Food food = foodRepository.findById(foodId).orElse(null);
        if (food == null) {
            log.error("Food not found");
            return List.of();
        }
        TableFood tableFood = TableFood.builder()
                .tableId(tableId)
                .food(food)
                .build();
        tableFoodRepository.save(tableFood);
        return tableFoodRepository.findFoodByTableId(tableId);
    }

    public List<Reservation> getReservations() {
        return restaurantService.getAllReservation();
    }

    public List<Table> getTables() {
        return restaurantService.getAllTables();
    }
}
