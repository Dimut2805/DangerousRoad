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

    void moveRight() {
        body.x += 5;
        leftWheel.getRectangle().x += 5;
        leftWheel.getWheel().setOrigin(leftWheel.getWheel().getWidth()/2,leftWheel.getWheel().getHeight()/2);
        leftWheel.getWheel().rotateBy(-15);
        rightWheel.getRectangle().x += 5;
        rightWheel.getWheel().setOrigin(rightWheel.getWheel().getWidth()/2,rightWheel.getWheel().getHeight()/2);
        rightWheel.getWheel().rotateBy(-15);
    }

    void moveLeft() {
        body.x -= 5;
        leftWheel.getRectangle().x -= 5;
        leftWheel.getWheel().setOrigin(leftWheel.getWheel().getWidth()/2,leftWheel.getWheel().getHeight()/2);
        leftWheel.getWheel().rotateBy(15);
        rightWheel.getRectangle().x -= 5;
        rightWheel.getWheel().setOrigin(rightWheel.getWheel().getWidth()/2,rightWheel.getWheel().getHeight()/2);
        rightWheel.getWheel().rotateBy(15);
    }

    public Wheel getRightWheel() {
        return rightWheel;
    }

    void drop() {
        body.y -= 10;
        leftWheel.getRectangle().y -= 10;
        rightWheel.getRectangle().y -= 10;
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