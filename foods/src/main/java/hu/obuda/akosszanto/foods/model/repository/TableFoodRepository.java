package hu.obuda.akosszanto.foods.model.repository;

import hu.obuda.akosszanto.foods.model.TableFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableFoodRepository extends JpaRepository<TableFood, Long> {

    List<TableFood> findFoodByTableId(Long tableId);
}
