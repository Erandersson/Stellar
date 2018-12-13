package com.stellar.src.main.classes;

import java.awt.*;

/**
 * Interface for the enemies.
 */

public interface EntityB {
    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();

    public double getX();
    public double getY();
}
