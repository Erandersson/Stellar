package com.stellar.src.main;

import com.stellar.src.main.classes.EntityA;
import java.awt.*;

/**
 * Bullet class creates the bullet/missile, which is generated in the Controller class.
 * In this class is the speed of the missile specified.
 */

public class Bullet extends GameObject implements EntityA {

    // VARIABLES

    private Textures tex;
    private Game game;

    // CONSTRUCTOR

    public Bullet(double x, double y, Textures tex, Game game){
        super(x, y);
        this.tex = tex;
        this.game = game;
    }

    // METHODS

    public void tick(){
        y -= 10;
    }
    public void render(Graphics g){
        g.drawImage(tex.bullet, (int)x, (int)y, null);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 9, 54);
    }
    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }
}
