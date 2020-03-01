package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


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

    public Wheel getLeftWheel() {
        return leftWheel;
    }


    void moveRight() {
        body.x += 5;
        leftWheel.getRectangle().x += 5;
        rightWheel.getRectangle().x += 5;
    }

    void moveLeft() {
        body.x -= 5;
        leftWheel.getRectangle().x -= 5;
        rightWheel.getRectangle().x -= 5;
    }

    void drop() {
        body.y -= 10;
        leftWheel.getRectangle().y -= 10;
        rightWheel.getRectangle().y -= 10;
    }

    public Wheel getRightWheel() {
        return rightWheel;
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(carTexture, body.x, body.y, body.width, body.height);
        batch.end();
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(body.x, body.y, body.width, body.height);
        shapeRendered.end();
        leftWheel.draw();
        rightWheel.draw();

    }
}