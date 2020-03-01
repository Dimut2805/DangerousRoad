package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public class Wheel implements Draw {
    private Texture texture;
    private TextureRegion textureRegion;
    private Rectangle rectangle;

    Wheel(float x, float y, int size) {
        texture = new Texture("wheel.png");
        textureRegion = new TextureRegion(texture, x, y, size, size);
        rectangle = new Rectangle(x, y, size, size);
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
        batch.draw(texture, 0, 0, 0, 0, 50, 50, 1f, 2.0f, 45f, 0, 0, 0, 0, false, false);
        batch.end();
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRendered.end();
    }
}