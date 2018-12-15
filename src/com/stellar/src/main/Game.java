package com.stellar.src.main;

import com.stellar.src.main.classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable{

    // VARIABLES

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320, HEIGHT = WIDTH / 12 * 9, SCALE = 2;
    public final String TITLE = "Stellar 2D Space Game";

    private boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage gameBackground = null;
    private BufferedImage menuBackground = null;

    private boolean isShooting = false;

    private int enemyCount = 1;
    private int enemyKilled = 0;

    private Player p;
    private Controller c;
    private Textures tex;
    private Menu menu;
    private State state = State.MENU;

    public LinkedList<EntityA> eA;
    public LinkedList<EntityB> eB;



    // METHODS

    public void setState(State s){
        state = s;
    }

    public void init(){
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/spriteSheet.png");
            gameBackground = loader.loadImage("/gameBackground.png");
            menuBackground = loader.loadImage("/menuBackground.png");
        } catch (IOException e){
            e.printStackTrace();
        }
        addKeyListener(new KeyInput(this));
        addMouseListener(new MouseInput());
        tex = new Textures(this);
        p = new Player(200,200, tex);
        c = new Controller(tex, this);
        menu = new Menu();

        eA = c.getEntityA();
        eB = c.getEntityB();

        c.createEnemy(enemyCount);
    }
    private synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    private synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(1);
    }

    // GAME LOOP

    public void run(){
        init();
        long initialTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - initialTime) / ns;
            initialTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + ", TICKS: " + updates );
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    private void tick(){
        if(state == State.GAME){
            p.tick();
            c.tick();
        }
        if(enemyKilled >= enemyCount){
            enemyCount += 1;
            enemyKilled = 0;
            c.createEnemy(enemyCount);
        }
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.black);
        g.fillRect(0,0,800,800);

        if(state == State.GAME){
            p.render(g);
            c.render(g);
            g.drawImage(gameBackground, 0,0,null);
        }else if(state == State.MENU){
            menu.render(g);
            //g.drawImage(menuBackground, 0,0,null);
        }

        g.dispose();
        bs.show();
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(state == State.GAME) {
            if (key == KeyEvent.VK_RIGHT) {
                p.setVelX(10);
            } else if (key == KeyEvent.VK_LEFT) {
                p.setVelX(-10);
            } else if (key == KeyEvent.VK_UP) {
                p.setVelY(-10);
            } else if (key == KeyEvent.VK_DOWN) {
                p.setVelY(10);
            } else if (key == KeyEvent.VK_SPACE && !isShooting) {
                c.addEntity(new Bullet(p.getX(), p.getY(), tex, c, this));
                isShooting = true;
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            p.setVelX(0);
        } else if(key == KeyEvent.VK_LEFT){
            p.setVelX(0);
        } else if(key == KeyEvent.VK_UP){
            p.setVelY(0);
        } else if(key == KeyEvent.VK_DOWN){
            p.setVelY(0);
        } else if(key == KeyEvent.VK_SPACE){
            isShooting = false;
        }
    }
    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }
    public int getEnemyCount() {
        return enemyCount;
    }
    public int getEnemyKilled() {
        return enemyKilled;
    }
    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }
    public void setEnemyKilled(int enemyKilled) {
        this.enemyKilled = enemyKilled;
    }
    public Controller getC(){
        return c;
    }

    // MAIN

    public static void main(String args[]){
        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}