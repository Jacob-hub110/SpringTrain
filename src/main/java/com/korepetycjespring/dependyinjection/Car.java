package com.korepetycjespring.dependyinjection;


public class Car {

    private Engine engine;

    // Wstrzykiwanie zaleznosci przez konsutruktor
    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    // Wstrzykiwanie zaleznosci przez setter/metode
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
