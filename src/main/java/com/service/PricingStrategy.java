package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 计价策略
 */
@Component
public class PricingStrategy {

    /**
     * 将PriceDiscount的实现类都注入到calculatedAmountMap中
     */
    @Autowired
    private Map<String, CalculatedAmount> calculatedAmountMap;

    /**
     * 通过传入bean名称获取bean
     * @param name
     * @return
     */
    public CalculatedAmount getPriceDiscount(String name) {
        return calculatedAmountMap.get(new StringBuilder(name).append("Service").toString());
    }

}
