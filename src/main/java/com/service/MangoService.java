package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 芒果
 */
@Service
@Slf4j
public class MangoService implements CalculatedAmount {
    @Value("${com.super.market.mango.price.discount:20.0,1.0}")
    private String priceWithDiscount;
    @Override
    public double calculated(double quantity) {
        String[] split = priceWithDiscount.split(",");
        Double price = Double.valueOf(split[0]);
        Double discount = Double.valueOf(split[1]);
        double total = quantity*price*discount;
        log.info("购买芒果：{}斤，单价：{}元/斤,芒果总共消费：{}/元",quantity,price,total);
        return total;
    }
}
