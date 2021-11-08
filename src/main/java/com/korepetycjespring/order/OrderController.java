package com.korepetycjespring.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    @GetMapping(value = "{orderId}")
    public Order getOrder(@PathVariable Integer orderId) {
        return new Order(orderId, "Testowego 1/23", 129.9);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //ustawiamy status odpowiedzi
    public Order createOrder(@RequestBody Order order) {
        System.out.println(order);
        order.setId(152);
        return order;
    }
}
