package com.stellar.src.main;

import java.awt.*;
import java.util.Random;

/**
 * Enemy class creates the enemy(s), which is generated in the Controller class.
 * In this class is the speed of the enemy(s) specified.
 */

public class Enemy implements Entity {

    // VARIABLES

    private double x, y;
    
    Random r = new Random();

    private int speed = (r.nextInt(3) + 1);

    private Textures tex;

    // CONSTRUCTORS

    public Enemy(double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    // METHODS

    public void tick(){
        y += speed;

        if(y > Game.HEIGHT * Game.SCALE + 84){
            y = -84;
            x = r.nextInt(Game.WIDTH * Game.SCALE);
        }
    }

    public void render(Graphics g){
        g.drawImage(tex.enemy,(int)x,(int)y,null);
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }

}
