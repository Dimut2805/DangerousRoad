package com.mygdx.game.model.car;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Draw;
import com.mygdx.game.model.car.Car;

public class Pedal implements Draw {
    private Vector3 touchPosition;
    private Texture pedalL;
    private Texture pedalR;
    private Batch batch;
    private Rectangle leftPedal;
    private Rectangle rightPedal;
    private Car car;

    public Pedal() {
        pedalL = new Texture("Pedal.png");
        pedalR = new Texture("Pedal2.png");
        batch = new SpriteBatch();
        leftPedal = new Rectangle();
        leftPedal.x = 50;
        leftPedal.y = 1;
        leftPedal.width = 150;
        leftPedal.height = 130;
        rightPedal = new Rectangle();
        rightPedal.x = 500;
        rightPedal.y = 1;
        rightPedal.height = 120;
        rightPedal.width = 150;
    }

    public void render() {
        batch.begin();
        batch.draw(pedalL,leftPedal.x,leftPedal.y,leftPedal.height,leftPedal.width);
        batch.draw(pedalR,rightPedal.x,rightPedal.y,rightPedal.height,rightPedal.width);
        batch.end();
        if (Gdx.input.isTouched()){ touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        if (leftPedal.contains(leftPedal)){
            car.moveLeft();
        }
        }
    }
}
