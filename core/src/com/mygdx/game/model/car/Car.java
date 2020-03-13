package com.mygdx.game.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Draw;
import com.mygdx.game.usemodel.map.RoadHitBox;


public class Car implements Draw {
    private Texture carTexture;
    private Rectangle body;
    private Wheel leftWheel;
    private Wheel rightWheel;

    public Car(int x, int width, int height) {
        body = new Rectangle(x, RoadHitBox.findLineHitBox(x).findY(x), width, height);
        carTexture = new Texture("car.png");
        leftWheel = new Wheel(body.x + 33, 50);
        rightWheel = new Wheel(body.x + body.width - 30 - 50, 50);
    }

    public Rectangle getBody() {
        return body;
    }


    public Wheel getRightWheel() {
        return rightWheel;
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