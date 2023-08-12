package com.example.springbasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PathVariableController {
    /**
     * path-variable 1
     *
     * @PathVariable String orderId
     * - url의 path-variable과 변수명을 맞춰준다.
     */
    @GetMapping("/order/path/{orderId}")
    public String getOrderPathVariable1(@PathVariable String orderId) {
        log.info("orderId : {}", orderId);
        return "orderId:" + orderId;
    }


    /**
     * path-variable 2
     *
     * @PathVariable("orderId") String id
     * - url의 path-variable과 @PathVariable 어노테이션의 매개변수 이름을 맞춰준다.
     */
    @GetMapping("/order2/path/{orderId}")
    public String getOrderPathVariable2(@PathVariable("orderId") String id) {
        log.info("orderId : {}", id);
        return "orderId:" + id;
    }

    /**
     * path-variable 3
     * PathVariable 다중 사용
     */
    @GetMapping("/order/path/{orderId}/{amount}")
    public String getOrderPathVariable3(@PathVariable String orderId, @PathVariable String amount) {
        log.info("orderID : {}, amount : {}", orderId, amount);
        return "orderId:" + orderId + " amount:" + amount;
    }
}
