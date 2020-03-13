package com.mygdx.game.usemodel.car;

import com.mygdx.game.model.car.Car;
import com.mygdx.game.usemodel.map.RoadHitBox;

public class RelationshipCar {
    private Car car;
    private int speed = 1;

    public RelationshipCar(int x, int width, int height) {
        car = new Car(x, width, height);
    }

    public void drawCar() {
        car.draw();
    }

    public Car getCar() {
        return car;
    }

    public void moveRight() {
        //Движение левого колеса
        car.getLeftWheel().getRectangle().x += speed;
        car.getLeftWheel().getRectangle()
                .setY(RoadHitBox.findLineHitBox(car.getLeftWheel().getWheel().getX())
                        .findY(car.getLeftWheel().getWheel().getX()));
        car.getLeftWheel().getWheel().setOrigin(car.getLeftWheel().getWheel().getWidth() / 2, car.getLeftWheel().getWheel().getHeight() / 2);
        car.getLeftWheel().getWheel().rotateBy(-15);
        //Движение правого колеса
        car.getRightWheel().getRectangle().x += speed;
        car.getRightWheel().getRectangle()
                .setY(RoadHitBox.findLineHitBox(car.getRightWheel().getWheel().getX())
                        .findY(car.getRightWheel().getWheel().getX()));
        car.getRightWheel().getWheel().setOrigin(car.getRightWheel().getWheel().getWidth() / 2, car.getRightWheel().getWheel().getHeight() / 2);
        car.getRightWheel().getWheel().rotateBy(-15);
    }


    public void moveLeft() {
        if (car.getLeftWheel().getWheel().getX() > 100) {
            //Движение левого колеса
            car.getLeftWheel().getRectangle().x -= speed;
            car.getLeftWheel().getRectangle()
                    .setY(RoadHitBox.findLineHitBox(car.getLeftWheel().getWheel().getX())
                            .findY(car.getLeftWheel().getWheel().getX()));
            car.getLeftWheel().getWheel().setOrigin(car.getLeftWheel().getWheel().getWidth() / 2, car.getLeftWheel().getWheel().getHeight() / 2);
            car.getLeftWheel().getWheel().rotateBy(15);
            //Движение правого колеса
            car.getRightWheel().getRectangle().x -= speed;
            car.getRightWheel().getRectangle()
                    .setY(RoadHitBox.findLineHitBox(car.getRightWheel().getWheel().getX())
                            .findY(car.getRightWheel().getWheel().getX()));
            car.getRightWheel().getWheel().setOrigin(car.getRightWheel().getWheel().getWidth() / 2, car.getRightWheel().getWheel().getHeight() / 2);
            car.getRightWheel().getWheel().rotateBy(15);
        }
    }
}