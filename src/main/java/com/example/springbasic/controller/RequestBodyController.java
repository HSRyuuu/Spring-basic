package com.example.springbasic.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("/order/body")
    public String getOrderRequestBody(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader String userAccountId) {
        log.info("Create order : {} , userAccountId : {}", createOrderRequest, userAccountId);
        return "orderId:" + createOrderRequest.getOrderId() + " amount:" + createOrderRequest.getOrderAmount();
    }

    @Data
    public static class CreateOrderRequest{
        private String orderId;
        private Integer orderAmount;
    }
}
