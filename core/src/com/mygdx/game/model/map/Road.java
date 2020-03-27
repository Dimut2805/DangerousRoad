package com.mygdx.game.model.map;

public class Road {
   private LineHitBox[] lineHitBoxes;

    public Road() {
        float x = 0, y = 200;
        lineHitBoxes = new LineHitBox[16];
        lineHitBoxes[0] = new LineHitBox(0,200,0, 400);
        for (int i = 1; i < 16; i++) {
            lineHitBoxes[i] = new LineHitBox(x, y, x + 400 + (float) (Math.random() * 700), y - 150 + (float) (Math.random() * 300));
            x = lineHitBoxes[i].getX2();
            y = lineHitBoxes[i].getY2();
        }
    }

    public LineHitBox[] getLineHitBoxes() {
        return lineHitBoxes;
    }
}
