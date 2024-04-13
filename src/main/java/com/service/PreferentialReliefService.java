package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 优惠减免
 */
@Service
@Slf4j
public class PreferentialReliefService implements CalculatedAmount {
    //是否开启优惠减免
    @Value("${com.super.market.preferential.relief.flag:false}")
    private boolean preferentialReliefFlag;
    //满多少开始减
    @Value("${com.super.market.preferential.relief.price}")
    private String preferentialReliefPrice;
    //减免金额
    @Value("${com.super.market.preferential.relief.amount}")
    private String preferentialReliefPriceAmount;
    @Override
    public double calculated(double quantity) {
        double total = quantity;
        //开启优惠减免
        if (preferentialReliefFlag){
            //说明配置了优惠减免
            if (!StringUtils.isEmpty(preferentialReliefPrice)&&!StringUtils.isEmpty(preferentialReliefPriceAmount)){
                //判断属于那个优惠区间
                String[] priceArr = preferentialReliefPrice.split(",");
                String[] amountArr = preferentialReliefPriceAmount.split(",");
                int index=-1;
                for (int i = 0; i < priceArr.length; i++) {
                    if (quantity>=Double.valueOf(priceArr[i])){
                        index = i;
                    }else {
                        break;
                    }
                }
                //说明符合优惠减免条件:购买满100元减10元...多种情况...
                if (index!=-1){
                    log.info("合计：{}/元，优惠减免：{}/元,总共消费：{}/元",total,amountArr[index],total-Double.valueOf(amountArr[index]));
                    total = total-Double.valueOf(amountArr[index]);
                }else {
                    log.info("合计：{}/元，无优惠减免,总共消费：{}/元",total,total);
                }
            }
        }
        return total;
    }
}
