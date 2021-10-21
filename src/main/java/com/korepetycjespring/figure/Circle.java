package com.korepetycjespring.figure;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {

    public String getFigureName(){
        return "Circle";
    }
}
