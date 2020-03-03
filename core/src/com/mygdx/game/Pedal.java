package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Pedal implements Draw {
    private Rectangle rectangle;
    private Texture texture;

    Pedal(int x, int y, int width, int height) {
        rectangle = new Rectangle(x, y, width, height);
        texture = new Texture("moveback.jpg");
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        batch.end();
    }
}