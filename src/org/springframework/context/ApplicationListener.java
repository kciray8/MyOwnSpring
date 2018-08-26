package org.springframework.context;

public interface ApplicationListener<E>{
    void onApplicationEvent(E event);
}