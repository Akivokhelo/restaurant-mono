package hu.obuda.akosszanto.foods.model.repository;

import hu.obuda.akosszanto.foods.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
