package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.game.Draw.shapeRendered;

public class LineHitBox {
    int x1, y1, x2, y2;

    LineHitBox(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    int getSlant() {
        return (y2 - y1) / (x2 - x1);
    }

    int findY(int x) {
        System.out.println(((-x * y2) + (x * y1) + (x1 * y2) + (-y1 * x2)) / (x1 - x2));
        return ((-x * y2) + (x * y1) + (x1 * y2) + (-y1 * x2)) / (x1 - x2);
    }

    public int[] leftPoint() {
        return new int[]{x1, y1};
    }

    public int[] rightPoint() {
        return new int[]{x2, y2};
    }

    public void showLine() {
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(1, 0, 0, 1);
        shapeRendered.line(x1, y1, x2, y2);
        shapeRendered.end();
    }
}
