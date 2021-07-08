package com.example.restaurantappBackend.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbmeal" ,  schema = "public")

public class Meal extends Dish{
    @Column(name = "freecoke")
    private Boolean freecoke;

    @Column(name = "frysize")
    private String frysize;

}
