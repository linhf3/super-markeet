package com.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sales12")
public class SalesStatisticalPrice {

    /**
     * 统计价格
     *
     * @param requestMap
     * @return double
     */
    @PostMapping("/sttics11re")
    public double statcalPricae(@RequestBody Map<String, Double> requestMap) {
        return 0.13;
    }

}
