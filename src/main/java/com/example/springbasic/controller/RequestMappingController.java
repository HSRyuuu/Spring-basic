package com.example.springbasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class RequestMappingController {
    @RequestMapping(value = "/requestmapping", method = RequestMethod.GET)
    public String requestMappingBasic() {
        log.info("RequestMapping");
        return "@RequestMapping";
    }

    /**
     * GetMapping
     */
    @GetMapping("/order/get")
    public String getOrder() {
        log.info("GetMapping");
        return "@GetMapping";
    }

    /**
     * PostMapping
     */
    @PostMapping("/order/post")
    public String createOrder() {
        log.info("create order");
        return "post mapping";
    }

    /**
     * Delete mapping
     */
    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable String orderId) {
        log.info("Delete order / orderId : {}", orderId);
        return "delete order - orderId:" + orderId;
    }




}
