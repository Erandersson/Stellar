package com.stellar.src.main;

import java.awt.*;

public class GameObject {

    // VARIABLES

    public double x, y;

    // CONSTRUCTORS

    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }

    // METHODS

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, width, height);
    }
}
