package com.kciray;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class ProductService implements InitializingBean, DisposableBean {
    @Autowired
    private PromotionsService promotionsService;

    public PromotionsService getPromotionsService() {
        return promotionsService;
    }

    public void setPromotionsService(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("PromotionsService init...");
    }

    @Override
    public void destroy() {
        System.out.println("PromotionsService destroy...");
    }

    @PreDestroy
    public void destroy2() {
        System.out.println("PromotionsService @PreDestroy...");
    }
}
