package com.stellar.src.main.classes;

import java.awt.*;

/**
 * Interface used for the enemy class.
 */

public interface EntityB {

    /**
     * Updates X and Y coordinates for the entities.
     * Adjusts velocities.
     * Checks for collisions, removes impacted objects if true.
     */
    public void tick();

    /**
     * Renders sprites for the objects.
     * @param g
     */
    public void render(Graphics g);

    /**
     * Getter used for the collision system.
     * @return Bounds for the objects.
     */
    public Rectangle getBounds();

    /**
     * Getter used to check x coordinates.
     * @return x coordinates for the entity.
     */
    public double getX();

    /**
     * Getter used to check y coordinates.
     * @return y coordinates for the entity.
     */
    public double getY();
}
