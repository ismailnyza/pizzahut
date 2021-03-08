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
    private Integer promoid;

    @Column(name = "promoname")
    private String promoname;

    @Column(name = "promodesc")
    private String promodesc;

    @Column(name = "promoimg")
    private String promoimg;

    @Column(name = "promoprice")
    private String promoprice;

}