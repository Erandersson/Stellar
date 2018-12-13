package com.stellar.src.main;

import java.awt.image.BufferedImage;

/**
 * Generates the sprites from SpriteSheet.
 * The index for the different sprites is found in the "res" folder.
 */

public class Textures {

    // VARIABLES

    public BufferedImage player, bullet, enemy;
    private SpriteSheet ss;

    // CONSTRUCTORS

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();

    }

    // METHODS

    private void getTextures(){
        player = ss.grabImage(211,941,99,75);
        bullet = ss.grabImage(856,421,9,54);
        enemy = ss.grabImage(423,728,93,84);
    }
}
