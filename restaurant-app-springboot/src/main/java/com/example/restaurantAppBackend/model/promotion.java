package com.example.restaurantappBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbpromotion" , schema = "public")

public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promoid")
    private Integer promoID;

    @Column(name = "promoname")
    private String promoName;

    @Column(name = "promodesc")
    private String promoDesc;

    @Column(name = "promoimg")
    private String promoImg;

    @Column(name = "promoprice")
    private String promoPrice;

    //todo should connect 2 dishes or something think of that later

}