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
@Table(name = "phdbappetizer" ,  schema = "public")

public class Appetizer extends Dish{

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "appetizertype")
    private String appetizertype;
}
