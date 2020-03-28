package com.mygdx.game;

import com.mygdx.game.model.car.Car;
import com.mygdx.game.model.map.Road;

public class Finish {
    public static boolean isFinish(Car car, Road road) {
        return road.getLineHitBoxes()[road.getLineHitBoxes().length - 1].getX1() <= car.getRightWheel().getRectangle().x + 10;
    }
}
