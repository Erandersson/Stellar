package com.stellar.src.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.stellar.src.main.Game;

import static com.stellar.src.main.State.GAME;

public class MouseInput extends MouseAdapter {

    private int mX;
    private int mY;

    public void mousePressed(MouseEvent e){
        mX = e.getX();
        mY = e.getY();
        // Pressed Play button
        if(mX >= playButton.getX() && mX <= playButton.getWidth()){
            if(mY >= playButton.getY() && mY <= playButton.getHeight()){
                Game.setState(GAME);
            }
        }
        // Pressed Quit button
        if(mX >= quitButton.getX() && mX <= quitButton.getWidth()){
            if(mY >= quitButton.getY() && mY <= quitButton.getHeight()){
                System.exit(1);
            }
        }
    }

}
