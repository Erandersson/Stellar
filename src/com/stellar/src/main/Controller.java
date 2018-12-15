package com.stellar.src.main;

import com.stellar.src.main.classes.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 */

public class Controller {

    // VARIABLES

    private LinkedList<EntityA> eA = new LinkedList<EntityA>();
    private LinkedList<EntityB> eB = new LinkedList<EntityB>();
    private Textures tex;
    EntityA entA;
    EntityB entB;
    Random r = new Random();
    private Game game;

    // CONSTRUCTORS

    public Controller(Textures tex, Game game){
        this.tex = tex;
        this.game = game;
    }

    // METHODS

    /**
     * Creates enemies in-game.
     * @param enemyCount Integer specifying how many enemies to create.
     */
    public void createEnemy(int enemyCount){
        for(int i = 0; i < enemyCount; i++){
            addEntity(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE - 93),-84,tex, this, game));
        }
    }

    /**
     * Calls entities A and B tick methods.
     */
    public void tick(){
        for (int i = 0; i < eA.size(); i++){
            entA = eA.get(i);
            entA.tick();
        }
        for (int i = 0; i < eB.size(); i++){
            entB = eB.get(i);
            entB.tick();
        }

    }
    public void render(Graphics g){
        for (int i = 0; i < eA.size(); i++) {
            entA = eA.get(i);
            entA.render(g);
        }
        for (int i = 0; i < eB.size(); i++) {
            entB = eB.get(i);
            entB.render(g);
        }
    }
    public void addEntity(EntityA block){
        eA.add(block);
    }
    public void removeEntity(EntityA block){
        eA.remove(block);
    }
    public void addEntity(EntityB block){
        eB.add(block);
    }
    public void removeEntity(EntityB block){
        eB.remove(block);
    }
    public LinkedList<EntityA> getEntityA(){
        return eA;
    }
    public LinkedList<EntityB> getEntityB(){
        return eB;
    }
}
