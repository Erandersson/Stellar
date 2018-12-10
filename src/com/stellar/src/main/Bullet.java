package com.stellar.src.main;

import java.awt.*;

/**
 * Bullet class creates the bullet/missile, which is generated in the Controller class.
 * In this class is the speed of the missile specified.
 */

public class Bullet implements Entity{

    // VARIABLES

    private double x, y;

    private Textures tex;

    // CONSTRUCTOR

    public Bullet(double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    // METHODS

    public void tick(){
        y -= 10;
    }

    public void render(Graphics g){
        g.drawImage(tex.bullet, (int)x, (int)y, null);
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }

}
