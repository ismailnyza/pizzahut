package com.example.restaurantappBackend.app.model;

import lombok.*;

import javax.persistence.*;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "phdbdish" ,  schema = "public")
//if the table is not mapped it doesnt need to be used

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

