package com.kciray;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.beans.factory.stereotype.Service;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Service
public class PromotionsService implements BeanNameAware, ApplicationListener<ContextClosedEvent> {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(">> ContextClosed EVENT");
    }
}
