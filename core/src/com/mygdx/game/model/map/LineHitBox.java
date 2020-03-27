package com.mygdx.game.model.map;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.game.Draw.shapeRendered;

public class LineHitBox {
    private float x1, y1, x2, y2;

    public LineHitBox(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float findY(float x) {
        return ((-x * y2) + (x * y1) + (x1 * y2) + (-y1 * x2)) / (x1 - x2);
    }

    public float getATan() {
        return (float) Math.atan((y2 - y1) / (x2 - x1));
    }

    public void setPosition(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getY1() {
        return y1;
    }

    public float getY2() {
        return y2;
    }

    public void showLine() {
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 0, 0, 1);
        shapeRendered.line(x1, y1, x2, y2);
        shapeRendered.end();
    }
}