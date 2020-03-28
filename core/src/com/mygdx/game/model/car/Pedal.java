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
        leftPedal.width = 200;
        leftPedal.height = Gdx.graphics.getHeight()-100;
        rightPedal = new Rectangle();
        rightPedal.x = 600;
        rightPedal.y = 1;
        rightPedal.height = Gdx.graphics.getHeight()-100;
        rightPedal.width = 200;
    }

    public void render() {
        batch.begin();
        batch.draw(pedalL,leftPedal.x,leftPedal.y,leftPedal.height,leftPedal.width);
        batch.draw(pedalR,rightPedal.x,rightPedal.y,rightPedal.height,rightPedal.width);
        batch.end();

    }

    public void move(Vector3 touchPosition, Car car){
        this.car = car;
        Rectangle rectangle = new Rectangle(touchPosition.x,touchPosition.y,1,1);
        if (leftPedal.overlaps(rectangle)){
            car.moveLeft();
            car.setIsMove(true);
        }

        if(rightPedal.overlaps(rectangle)){
            car.moveRight();
            car.setIsMove(true);
        }
    }
}
