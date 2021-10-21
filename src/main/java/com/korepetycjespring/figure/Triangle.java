package com.korepetycjespring.figure;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Figure{

    public String getFigureName(){
        return "Triangle";
    }
}
