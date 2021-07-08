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
@Table(name = "phdbentree" ,  schema = "public")

public class Entree extends Dish{
    @Column(name = "dishquantity")
    private String dishquantity;
}
