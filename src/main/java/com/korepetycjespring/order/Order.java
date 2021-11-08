package com.korepetycjespring.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Order {

    private Integer id;
    private String address;
    private double price;

}


