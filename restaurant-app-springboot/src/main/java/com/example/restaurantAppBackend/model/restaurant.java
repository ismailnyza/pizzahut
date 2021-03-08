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
    @Column(name = "restaurantid")
    private Integer restaurantid;

    @Column(name = "restaurantname")
    private String restaurantname;

    @Column(name = "restaurantimg")
    private String restaurantimg;

    @Column(name = "restaurantaddress")
    private String restaurantaddress;

}
