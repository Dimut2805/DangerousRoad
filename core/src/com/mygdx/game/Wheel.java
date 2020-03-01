package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Wheel implements Draw {
    private Texture wheel;
    private Rectangle rectangle;

    Wheel(float x, float y, int size) {
        wheel = new Texture("wheel.png");
        rectangle = new Rectangle(x, y, size, size);
        sprite.setTexture(wheel);
        sprite.setPosition(x, y);
    }

    boolean onLand() {
        return rectangle.y <= 130;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw() {
        batch.begin();
        sprite.draw(batch);
        batch.end();
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRendered.end();
    }
}
