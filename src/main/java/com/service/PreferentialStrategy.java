package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 优惠策略获取
 */
@Component
public class PreferentialStrategy {
    /**
     * 将Favorable的实现类都注入到favorableMap中
     */
    @Autowired
    private Map<String, Favorable> favorableMap;

    /**
     * 通过传入bean名称获取bean
     * @param beanName
     * @return
     */
    public Favorable getFavorable(String beanName) {
        return favorableMap.get(beanName);
    }
}
