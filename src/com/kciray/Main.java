package com.kciray;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

public class Main {

    public static void main(String[] args){
        new Main();
    }

    public Main(){
        try {
            testBeanFactory();
            testContext();
        }catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    void testBeanFactory() throws ReflectiveOperationException{
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());

        beanFactory.instantiate("com.kciray");
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.initializeBeans();

        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);//ProductService@612

        PromotionsService promotionsService = productService.getPromotionsService();
        System.out.println(promotionsService);
        System.out.println("Bean name = " + promotionsService.getBeanName());

        System.out.println(promotionsService.getClass());

        beanFactory.close();
    }

    void testContext() throws ReflectiveOperationException{
        ApplicationContext applicationContext = new ApplicationContext("com.kciray");
        applicationContext.close();
    }
}