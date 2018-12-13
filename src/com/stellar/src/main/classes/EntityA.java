package com.stellar.src.main.classes;

import java.awt.*;

/**
 * Interface for the player and missile.
 */

public interface EntityA {
    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();

    public double getX();
    public double getY();
}
