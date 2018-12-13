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
    private Controller c;

    // CONSTRUCTOR

    public Bullet(double x, double y, Textures tex, Controller c, Game game){
        super(x, y);
        this.tex = tex;
        this.c = c;
        this.game = game;
    }

    // METHODS

    public void tick(){
        y -= 10;
        if(y > Game.HEIGHT * Game.SCALE - 54){
            c.removeEntity(this);
        }
        if(Physics.Collision(this, game.eB)){
            c.removeEntity(this);
        }
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
