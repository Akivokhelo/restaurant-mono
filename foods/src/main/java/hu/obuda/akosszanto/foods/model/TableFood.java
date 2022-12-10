package hu.obuda.akosszanto.foods.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_FOOD")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableFood {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    private Long tableId;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;



}
