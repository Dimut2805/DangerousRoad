package com.mygdx.game.model.map;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.game.Draw.shapeRendered;

public class LineHitBox {
    private int x1, y1, x2, y2;

    public LineHitBox(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getSlant() {
        return (y2 - y1) / (x2 - x1);
    }

    public float findY(float x) {
        return ((-x * y2) + (x * y1) + (x1 * y2) + (-y1 * x2)) / (x1 - x2);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void showLine() {
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(1, 0, 0, 1);
        shapeRendered.line(x1, y1, x2, y2);
        shapeRendered.end();
    }
}
