package com.mygdx.game.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.model.map.LineHitBox;
import com.mygdx.game.model.map.Road;
import com.mygdx.game.usemodel.map.RoadHitBox;

public class Car {
    ShapeRenderer shapeRendered = new ShapeRenderer();
    private Rectangle body;
    private Wheel leftWheel;
    private Wheel rightWheel;
    private Image car;
    private LineHitBox lineHitBox;
    private Road road;
    private float speed, rotateWheel;
    private boolean isMove, isRight, isLeft;

    public Car(float x, final float width, final float height, Road road) {
        rotateWheel = 3;
        isLeft = false;
        isLeft = false;
        isMove = false;
        speed = 0;
        this.road = road;
        body = new Rectangle(x, RoadHitBox.findLineHitBox(x, road).findY(x), width, height);
        leftWheel = new Wheel(body.x + 33, 50);
        rightWheel = new Wheel(body.x + body.width - 30 - 50, 50);
        lineHitBox = new LineHitBox(leftWheel.getWheel().getX(), leftWheel.getWheel().getY() + 50, rightWheel.getWheel().getX() + 50, rightWheel.getWheel().getY() + 50);
        car = new Image(new Texture("car.png")) {{
            setPosition(leftWheel.getRectangle().x, leftWheel.getRectangle().y);
            setWidth(width);
            setHeight(height);
        }};
    }

    public void setIsMove(boolean isMove) {
        this.isMove = isMove;
    }

    public Image getCarImage() {
        return car;
    }

    public void moveRight() {
        moveRoadRight(speed);
        leftWheel.rotateRight();
        rightWheel.rotateRight();
    }

    public void moveLeft() {
        if(road.getLineHitBoxes()[road.getLineHitBoxes().length-1].getX1() <= rightWheel.getRectangle().x+10) {
            System.out.println("Финиш");
        }
        if (road.getLineHitBoxes()[0].getX1() < 110) {
            moveRoadLeft(speed);
            leftWheel.rotateLeft();
            rightWheel.rotateLeft();
        }
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public void setIsLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    private void speedUp() {
        if (isMove) {
            if (rotateWheel < 15) {
                rotateWheel+=0.5;
            }
            if (speed < 7) {
                speed += 1;
            }
        }
        if (speed != 0) {
            if (!isMove && (isRight || isLeft)) {
                speed -= 0.5;
                rotateWheel--;
                if (isLeft) {
                    moveLeft();
                }
                if (isRight) {
                    moveRight();
                }
            }
        }
    }

    public Wheel getRightWheel() {
        return rightWheel;
    }

    public Wheel getLeftWheel() {
        return leftWheel;
    }

    private void moveRoadRight(float speed) {
        for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
            lineHitBox.setPosition(lineHitBox.getX1() - speed, lineHitBox.getY1(), lineHitBox.getX2() - speed, lineHitBox.getY2());
        }
    }

    private void moveRoadLeft(float speed) {
        for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
            lineHitBox.setPosition(lineHitBox.getX1() + speed, lineHitBox.getY1(), lineHitBox.getX2() + speed, lineHitBox.getY2());
        }
    }

    public void render() {
        speedUp();
        leftWheel.render();
        rightWheel.render();
        lineHitBox.setPosition(leftWheel.getRectangle().x - 30, leftWheel.getRectangle().y + 50, rightWheel.getRectangle().x + 50 + 30, rightWheel.getRectangle().y + 50);
        car.setPosition(lineHitBox.getX1(), lineHitBox.getY1() - 23);
        car.setRotation(lineHitBox.getATan() * 100);
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.line(lineHitBox.getX1(), lineHitBox.getY1(), lineHitBox.getX2(), lineHitBox.getY2());
        shapeRendered.end();
    }

    public class Wheel {
        ShapeRenderer shapeRendered = new ShapeRenderer();
        private Rectangle rectangle;
        private Image wheel;

        Wheel(float x, int size) {
            rectangle = new Rectangle(x, RoadHitBox.findLineHitBox(x, road).findY(x), size, size);
            wheel = new Image(new Texture("wheel.png")) {{
                setPosition(rectangle.x, rectangle.y);
                setWidth(rectangle.width + 5);
                setHeight(rectangle.height);
            }};
        }


        public Image getWheel() {
            return wheel;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

        public void render() {
            if (wheel.getY() != 200) {
                if (wheel.getY() > 200) {
                    transferRoadDown();
                }
                if (wheel.getY() < 200) {
                    transferRoadUp();
                }
            }
            rectangle
                    .setY(RoadHitBox.findLineHitBox(wheel.getX(), road)
                            .findY(wheel.getX()));
            wheel.setPosition(rectangle.x - 3, rectangle.y);
            shapeRendered.begin(ShapeRenderer.ShapeType.Line);
            shapeRendered.setColor(0, 1, 0, 1);
            shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            shapeRendered.end();
        }

        public void rotateRight() {
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(-rotateWheel);
        }

        public void rotateLeft() {
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(rotateWheel);
        }

        private void transferRoadUp() {
            for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
                lineHitBox.setPosition(lineHitBox.getX1(), lineHitBox.getY1() + 1, lineHitBox.getX2(), lineHitBox.getY2() + 1);
            }
        }

        private void transferRoadDown() {
            for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
                lineHitBox.setPosition(lineHitBox.getX1(), lineHitBox.getY1() - 1, lineHitBox.getX2(), lineHitBox.getY2() - 1);
            }
        }
    }
}