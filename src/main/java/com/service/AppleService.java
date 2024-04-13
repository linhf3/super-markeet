package com.service;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 苹果
 */
@Service
@Slf4j
public class AppleService implements CalculatedAmount{

    @Value("${com.super.market.apple.price.discount:8.0,1.0}")
    private String priceWithDiscount;

    @Override
    public double calculated(double quantity) {
        String[] split = priceWithDiscount.split(",");
        Double price = Double.valueOf(split[0]);
        Double discount = Double.valueOf(split[1]);
        double total = quantity*price*discount;
        log.info("购买苹果：{}斤，单价：{}元/斤,苹果总共消费：{}/元",quantity,price,total);
        return total;
    }
}
