package com.stellar.src.main;

import java.awt.*;

/**
 * Interface for the different entities, i.e. player, missile etc.
 */

public interface Entity {

    public void tick();
    public void render(Graphics g);

    public double getX();
    public double getY();
}
