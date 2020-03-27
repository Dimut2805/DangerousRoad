package com.mygdx.game.model.map;

public class Road {
   private LineHitBox[] lineHitBoxes;

    public Road() {
        float x = 0, y = 300;
        lineHitBoxes = new LineHitBox[15];
        for (int i = 0; i < 15; i++) {
            lineHitBoxes[i] = new LineHitBox(x, y, x + 400 + (float) (Math.random() * 700), y - 150 + (float) (Math.random() * 150));
            x = lineHitBoxes[i].getX2();
            y = lineHitBoxes[i].getY2();
        }
    }

    public LineHitBox[] getLineHitBoxes() {
        return lineHitBoxes;
    }
}
