package com.example.springbasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestParamController {
    /**
     * request-param 1
     */
    @GetMapping("/order/param1")
    public String getOrderRequestParam1(
            @RequestParam("orderId") String id,
            @RequestParam("orderAmount") String amount) {
        log.info("orderID : {}, orderAmount : {}", id, amount);
        return "orderId:" + id + " amount:" + amount;
    }

    /**
     * request-param 2
     * required
     */
    @GetMapping("/order/param2")
    public String getOrderRequestParam2(
            @RequestParam(value = "orderId", required = true) String id,
            @RequestParam(value = "orderAmount", required = false, defaultValue = "100") String amount) {
        log.info("orderID : {}, orderAmount : {}", id, amount);
        return "orderId:" + id + " amount:" + amount;
    }
}
