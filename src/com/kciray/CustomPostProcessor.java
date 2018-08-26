package com.kciray;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("---CustomPostProcessor Before " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("---CustomPostProcessor After " + beanName);
        return bean;
    }
}
