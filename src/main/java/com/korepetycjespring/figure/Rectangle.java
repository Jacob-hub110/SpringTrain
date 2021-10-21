package com.korepetycjespring.figure;

import org.springframework.stereotype.Component;
//Adnotacja Component, sprawia ze zostanie stworzony bean klasy Rectangle
@Component
public class Rectangle implements Figure {

    public String getFigureName() {
        return "Rectangle";
    }

}
