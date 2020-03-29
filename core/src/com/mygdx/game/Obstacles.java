package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.model.car.Car;

import java.util.ArrayList;
import java.util.Iterator;

public class Obstacles {
    private long lastDropTime;
    private ArrayList<Stone> stoneArrayList;
    private Car car;
    private SpriteBatch batch = new SpriteBatch();
    private BitmapFont text = new BitmapFont();


    Obstacles(Car car) {
        this.car = car;
        stoneArrayList = new ArrayList<>();
    }

    void spawnObstacles() {
        stoneArrayList.add(new Stone(0 + (int) (Math.random() * Gdx.graphics.getWidth() + 30), Gdx.graphics.getHeight() + 100, ((int) Math.round((Math.random() * 30) - 15))));
        lastDropTime = TimeUtils.nanoTime();
    }

    public void fall() {
        Iterator<Stone> iter = stoneArrayList.iterator();
        while (iter.hasNext()) {
            Stone stone = iter.next();
            stone.getRectangle().x += stone.getCornerFall();
            stone.getRectangle().y -= 3 + (int) Math.random() * 8;
            if (stone.getRectangle().y + stone.getRectangle().height < 0) {
                iter.remove();
            }
            if(stone.getRectangle().overlaps(car.getBody())) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(1);
            }
            stone.draw();
        }
    }

    public void moveRight() {
        if (car.isRight() && car.isMove()) {
            for (Stone stone : stoneArrayList) {
                stone.getRectangle().x -= car.getSpeed();
            }
        }
    }

    public void moveLeft() {
        if (car.isLeft() && car.isMove()) {
            for (Stone stone : stoneArrayList) {
                stone.getRectangle().x += car.getSpeed();
            }
        }
    }
    void render() {
        if (TimeUtils.nanoTime() - lastDropTime > 800000000) spawnObstacles();
        fall();
        moveLeft();
        moveRight();
    }
}