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

    //        public Integer getDishid() {
    //            return dishid;
    //        }
    //
    //        public void setDishid(Integer dishid) {
    //            this.dishid = dishid;
    //        }
    //
    //        public String getDishname() {
    //            return dishname;
    //        }
    //
    //        public void setDishname(String dishname) {
    //            this.dishname = dishname;
    //        }
    //
    //        public String getDishdesc() {
    //            return dishdesc;
    //        }
    //
    //        public void setDishdesc(String dishdesc) {
    //            this.dishdesc = dishdesc;
    //        }
    //
    //        public String getDishimg() {
    //            return dishimg;
    //        }
    //
    //        public void setDishimg(String dishimg) {
    //            this.dishimg = dishimg;
    //        }
    //
    //        public String getDishprice() {
    //            return dishprice;
    //        }
    //
    //        public void setDishprice(String dishprice) {
    //            this.dishprice = dishprice;
    //    }
}

