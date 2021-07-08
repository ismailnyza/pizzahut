package com.example.restaurantappBackend.app.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbtoppings" ,  schema = "public")


public class Topping {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toppingid")
    private Integer toppingid;

    @Column(name = "toppingname")
    private String toppingname;

    @Column(name = "toppingprice")
    private Integer toppingprice;
}

