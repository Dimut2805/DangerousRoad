package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RelationshipCar {
    private Car car;
    private boolean onLand;
    private LineHitBox lineOnLand;
    int speed = 1;

    RelationshipCar(int x, int y, int width, int height) {
        onLand = false;
        car = new Car(x, y, width, height);
    }

    void drawCar() {
        car.draw();
    }

    public Car getCar() {
        return car;
    }

    void moveRight() {
        if (onLand && lineOnLand.y1 != lineOnLand.y2) {
            car.getBody().y = lineOnLand.findY((int) (car.getBody().x + speed));
            car.getRightWheel().getRectangle().y = lineOnLand.findY((int) (car.getRightWheel().getRectangle().x + speed));
            car.getLeftWheel().getRectangle().y = lineOnLand.findY((int) (car.getLeftWheel().getRectangle().x + speed));
        }
        //System.out.println(car.getBody().y);
        car.getBody().x += speed;
        car.getLeftWheel().getRectangle().x += speed;
        car.getLeftWheel().getWheel().setOrigin(car.getLeftWheel().getWheel().getWidth() / 2, car.getLeftWheel().getWheel().getHeight() / 2);
        car.getLeftWheel().getWheel().rotateBy(-15);
        car.getRightWheel().getRectangle().x += speed;
        car.getRightWheel().getWheel().setOrigin(car.getRightWheel().getWheel().getWidth() / 2, car.getRightWheel().getWheel().getHeight() / 2);
        car.getRightWheel().getWheel().rotateBy(-15);
    }


    void moveLeft() {
        car.getBody().x -= speed;
        car.getLeftWheel().getRectangle().x -= speed;
        car.getLeftWheel().getWheel().setOrigin(car.getLeftWheel().getWheel().getWidth() / 2, car.getLeftWheel().getWheel().getHeight() / 2);
        car.getLeftWheel().getWheel().rotateBy(15);
        car.getRightWheel().getRectangle().x -= speed;
        car.getRightWheel().getWheel().setOrigin(car.getRightWheel().getWheel().getWidth() / 2, car.getRightWheel().getWheel().getHeight() / 2);
        car.getRightWheel().getWheel().rotateBy(15);
    }

    void overlapWheel(LineHitBox[] lineHitBoxes) {
        Image wheel = car.getRightWheel().getWheel();
        int x = (int) wheel.getX();
        int y = (int) wheel.getY();
        for (LineHitBox lineHitBox : lineHitBoxes) {
            if (x + wheel.getImageWidth() >= lineHitBox.x1 && x + wheel.getImageWidth() <= lineHitBox.x2) {
                if (y - lineHitBox.y1 <= lineHitBox.getSlant() * (x + wheel.getImageWidth() - lineHitBox.x1)) {
                    onLand = true;
                    lineOnLand = lineHitBox;
                } else {
                    car.drop();
                    onLand = false;
                }
            }
        }
    }
}