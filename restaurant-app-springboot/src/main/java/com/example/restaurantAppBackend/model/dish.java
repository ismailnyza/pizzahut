package com.example.restaurantappBackend.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbdish" ,  schema = "public")


public class Dish {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishid")
    private Integer dishid;

    @Column(name = "dishname")
    private String dishname;

    @Column(name = "dishdesc")
    private String dishdesc;

    @Column(name = "dishimg")
    private String dishimg;

    @Column(name = "dishprice")
    private String dishprice;

}

