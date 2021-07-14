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
@Table(name = "phdbpizza" ,  schema = "public")

public class Pizza extends Dish{

    @Column(name = "dishtoppings")
    private String dishToppings;

    @Column(name = "dishsize")
    private String dishSize;

}
