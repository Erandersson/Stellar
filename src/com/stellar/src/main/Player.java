package com.stellar.src.main;

import com.stellar.src.main.classes.EntityA;

import java.awt.*;

/**
 * Player class creates the player, which is generated in the Controller class.
 * In this class is the player bounds is specified.
 */

public class Player extends GameObject implements EntityA {

    // VARIABLES

    private double velX = 0, velY = 0;
    private Textures tex;

    // CONSTRUCTORS

    public Player(double x, double y, Textures tex){
        super(x, y);
        this.tex = tex;
    }

    // METHODS

    public void tick(){
        x+=velX;
        y+=velY;
        if(x <= 0){
            x = 0;
        }
        if(x >= 640-99){
            x = 640-99;
        }
        if(y <= 0){
            y = 0;
        }
        if(y >= 480-88){
            y = 480-88;
        }
    }
    public void render(Graphics g){
        g.drawImage(tex.player, (int)x, (int)y, null);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 99, 75);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setVelX(double velX){
        this.velX = velX;
    }
    public void setVelY(double velY){
        this.velY = velY;
    }
}