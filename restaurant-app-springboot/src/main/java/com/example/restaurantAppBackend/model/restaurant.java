package com.example.restaurantappBackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phdbrestaurant" , schema = "public")


public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaunratid")
    private Integer restaurantID;

    @Column(name = "restaurantname")
    private String restaurantName;

    @Column(name = "restaurantimg")
    private String restaurantImg;

    @Column(name = "restaurantdesc")
    private String restaurantDesc;

}
