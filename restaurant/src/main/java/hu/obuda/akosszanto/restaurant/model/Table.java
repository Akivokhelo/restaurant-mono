package hu.obuda.akosszanto.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity
@javax.persistence.Table(name = "TABLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String picture;

    public Boolean winterReady;

    public Integer chairs;
}
