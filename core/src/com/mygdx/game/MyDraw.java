package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.game.Draw.shapeRendered;

class MyDraw {
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    public static void line(int x1, int y1, int x2, int y2) {
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(1, 0, 0, 1);
        shapeRendered.line(x1, y1, x2, y2);
        shapeRendered.end();
    }
}