package com.controller;

import com.service.CalculatedAmount;
import com.service.PreferentialStrategy;
import com.service.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sales")
public class SalesStatisticalPrice {

    @Autowired
    private PricingStrategy pricingStrategy;

    @Autowired
    private PreferentialStrategy preferentialStrategy;

    /**
     * 统计价格
     *
     * @param requestMap
     * @return double
     */
    @PostMapping("/statisticalPrice")
    public double statisticalPrice(@RequestBody Map<String, Double> requestMap) {
        double result = 0d;
        if (CollectionUtils.isEmpty(requestMap)) {
            return result;
        }
        //1、计算买的水果总价格：requestMap:key为beanName，value为购买数量
        for (Map.Entry<String, Double> entry : requestMap.entrySet()) {
            CalculatedAmount calculatedAmount = pricingStrategy.getPriceDiscount(entry.getKey());
            result += calculatedAmount.calculated(entry.getValue());
        }
        //2、是否开启满多少减多少优惠，根据购买情况优惠力度可能不一样
        return preferentialStrategy.getFavorable("preferentialReliefService").calculated(result);
    }

}
