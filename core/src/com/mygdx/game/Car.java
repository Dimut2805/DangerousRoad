package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Arrays;


public class Car implements Draw {
    private Texture carTexture;
    private Rectangle body;
    private Wheel leftWheel;
    private Wheel rightWheel;

    Car(int x, int y, int width, int height) {
        body = new Rectangle(x, y, width, height);
        carTexture = new Texture("car.png");
        leftWheel = new Wheel(body.x + 33, body.y - 28, 50);
        rightWheel = new Wheel(body.x + body.width - 30 - 50, body.y - 23, 50);
    }

    public Rectangle getBody() {
        return body;
    }


    public Wheel getRightWheel() {
        return rightWheel;
    }

    void drop() {
        body.y -= 1;
        leftWheel.getRectangle().y -= 1;
        rightWheel.getRectangle().y -= 1;
    }

    public Wheel getLeftWheel() {
        return leftWheel;
    }

    @Override
    public void draw() {
        leftWheel.draw();
        rightWheel.draw();
        batch.begin();
        batch.draw(carTexture, body.x, body.y, body.width, body.height);
        batch.end();
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(body.x, body.y, body.width, body.height);
        shapeRendered.end();
    }
}