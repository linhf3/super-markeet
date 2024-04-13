package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 草莓
 */
@Service
@Slf4j
public class StrawberriesService implements CalculatedAmount {
    @Value("${com.super.market.strawberries.price.discount:13.0,1.0}")
    private String priceWithDiscount;
    @Override
    public double calculated(double quantity) {
        String[] split = priceWithDiscount.split(",");
        Double price = Double.valueOf(split[0]);
        Double discount = Double.valueOf(split[1]);
        double total = quantity*price*discount;
        log.info("购买草莓：{}斤，单价：{}元/斤,草莓总共消费：{}/元",quantity,price,total);
        return total;
    }
}
