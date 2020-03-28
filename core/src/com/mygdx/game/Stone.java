package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Stone {
    private Batch batch = new SpriteBatch();
    private Texture stoneTexture = new Texture("stone.png");
    private Rectangle rectangle;
    private int cornerFall;

    public Stone(int x, int y, int cornerFall) {
        this.cornerFall = cornerFall;
        int sizeStone = 50 + (int) Math.random() * 70;
        rectangle = new Rectangle(x, y, sizeStone, sizeStone);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getCornerFall() {
        return cornerFall;
    }

    public void draw() {
        batch.begin();
        batch.draw(stoneTexture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        batch.end();
    }
}
