package hu.obuda.akosszanto.foods.controller;

import hu.obuda.akosszanto.foods.model.Food;
import hu.obuda.akosszanto.foods.model.TableFood;
import hu.obuda.akosszanto.foods.model.other.Reservation;
import hu.obuda.akosszanto.foods.model.other.Table;
import hu.obuda.akosszanto.foods.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rest/v1/foods")
@Slf4j
@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all foods",
            description = "Get all foods",
            tags = {"food"},
            operationId = "getAllFoods")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/all/{tableId}")
    @Operation(summary = "Get all foods by table id",
            description = "Get all foods by table id",
            tags = {"food"},
            operationId = "getFoodByTableId")
    public List<TableFood> getFoodByTableId(@PathVariable Long tableId) {
        return foodService.getFoodByTableId(tableId);
    }

    @PostMapping("/add")
    @Operation(summary = "Add a food",
            description = "Add a food",
            tags = {"food"},
            operationId = "addFood")
    public List<TableFood> addFood(@RequestParam Long foodId, @RequestParam Long tableId) {
        return foodService.addFoodToTable(tableId, foodId);
    }

    @GetMapping("/reservations")
    @Operation(summary = "Get all reservations",
            description = "Get all reservations",
            tags = {"reservation"},
            operationId = "getAllReservations")
    public List<Reservation> getReservations() {
        return foodService.getReservations();
    }

    @GetMapping("/tables")
    @Operation(summary = "Get all tables",
            description = "Get all tables [requires auth]",
            tags = {"table"},
            operationId = "getAllTables")
    public List<Table> getTables() {
        return foodService.getTables();
    }

}
