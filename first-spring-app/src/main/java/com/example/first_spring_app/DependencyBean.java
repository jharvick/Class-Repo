package com.example.first_spring_app;

import org.springframework.stereotype.Component;

@Component
public class DependencyBean {
    public void printDependency() {
        System.out.println("DependencyBean is injected!");
    }
}
