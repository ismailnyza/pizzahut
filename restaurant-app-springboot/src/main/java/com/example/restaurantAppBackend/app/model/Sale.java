package com.example.restaurantappBackend.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbsales" ,  schema = "public")


public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesid")
    private Integer saleid;

    @Column(name = "purchasedcart")
    private String purchasedcart;

    @Column(name = "purchasedtotal")
    private Integer purchasedtotal;

    @Column(name = "purchasedtime")
    private String purchasedtime;
}
