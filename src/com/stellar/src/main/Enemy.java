package com.stellar.src.main;

import com.stellar.src.main.classes.EntityB;
import java.awt.*;
import java.util.Random;

/**
 * Enemy class creates the enemy(s), which is generated in the Controller class.
 * In this class is the speed of the enemy(s) specified.
 */

public class Enemy extends GameObject implements EntityB {

    // VARIABLES

    Random r = new Random();
    private int speed = (r.nextInt(3) + 1);
    private Textures tex;
    private Game game;
    private Controller c;

    // CONSTRUCTORS

    public Enemy(double x, double y, Textures tex, Controller c, Game game){
        super(x, y);
        this.tex = tex;
        this.c = c;
        this.game = game;
    }

    // METHODS
    public void tick(){
        y += speed;
        if(y > Game.HEIGHT * Game.SCALE + 84){
            speed = r.nextInt(3) + 1;
            y = -84;
            x = r.nextInt(Game.WIDTH * Game.SCALE - 93);
        }
        if(Physics.Collision(this, game.eA)){
            c.removeEntity(this);
            game.setEnemyKilled(game.getEnemyKilled() + 1);
        }
    }
    public void render(Graphics g){
        g.drawImage(tex.enemy,(int)x,(int)y,null);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 93, 84);
    }
    public double getY(){
        return y;
    }
    public double getX(){
        return x;
    }
}
