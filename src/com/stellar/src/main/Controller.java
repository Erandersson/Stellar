package com.stellar.src.main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 */

public class Controller {

    // VARIABLES

    private LinkedList<Entity> e = new LinkedList<Entity>();
    private Textures tex;
    Entity ent;
    Random r = new Random();

    // CONSTRUCTORS

    public Controller(Textures tex){
        this.tex = tex;
    }

    // METHODS

    public void createEnemy(int enemyCount){
        for(int i = 0; i < enemyCount; i++){
            addEntity(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE - 99),-84,tex));
        }
    }

    public void tick(){
        for (int i = 0; i < e.size(); i++){
            ent = e.get(i);

            ent.tick();
        }

    }
    public void render(Graphics g){
        for (int i = 0; i < e.size(); i++) {
            ent = e.get(i);

            ent.render(g);
        }
    }
    public void addEntity(Entity block){
        e.add(block);
    }
    public void removeEntity(Entity block){
        e.remove(block);
    }
}
