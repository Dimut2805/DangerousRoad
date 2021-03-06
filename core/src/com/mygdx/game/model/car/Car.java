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
    private LineHitBox carBodyLineHitBox;
    private Road road;
    private float speed = 0, rotateWheel = 3;
    private boolean isMove = false, isRight = false, isLeft = false;

    public Image getCar() {
        return car;
    }

    public Car(float x, final float width, final float height, Road road) {
        this.road = road;
        body = new Rectangle(x, RoadHitBox.findLineHitBox(x, road).findY(x), width, height);
        leftWheel = new Wheel(body.x + 33, 50);
        rightWheel = new Wheel(body.x + body.width - 30 - 50, 50);
        carBodyLineHitBox = new LineHitBox(leftWheel.getWheel().getX(), leftWheel.getWheel().getY() + 50, rightWheel.getWheel().getX() + 50, rightWheel.getWheel().getY() + 50);
        car = new Image(new Texture("car.png")) {{
            setPosition(leftWheel.getRectangle().x, leftWheel.getRectangle().y);
            setWidth(width);
            setHeight(height);
        }};
    }

    public Rectangle getBody() {
        return body;
    }

    public void setIsMove(boolean isMove) {
        this.isMove = isMove;
    }

    public Image getCarImage() {
        return car;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void moveRight() {
        moveRoadRight(speed);
        leftWheel.rotateRight();
        rightWheel.rotateRight();
    }

    public void moveLeft() {
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

    public boolean isMove() {
        return isMove;
    }

    private void speedUp() {
        if (isMove) {
            if (rotateWheel < 15) {
                rotateWheel += 0.5;
            }
            if (speed < 7) {
                speed += 1;
            }
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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

    private void camera() {
        if (rightWheel.getWheel().getY() != 200) {
            if (rightWheel.getWheel().getY() > 200) {
                road.transferRoadDown();
            }
            if (rightWheel.getWheel().getY() < 200) {
                road.transferRoadUp();
            }
        }
    }

    private void drawWheels() {
        leftWheel.render();
        rightWheel.render();
    }

    public void render() {
        camera();
        drawWheels();
        speedUp();
        carBodyLineHitBox.setPosition(leftWheel.getRectangle().x - 30, leftWheel.getRectangle().y + 50, rightWheel.getRectangle().x + 50 + 30, rightWheel.getRectangle().y + 50);
        car.setPosition(carBodyLineHitBox.getX1(), carBodyLineHitBox.getY1() - 23);
        car.setRotation(carBodyLineHitBox.getATan() * 100);
        /*shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.line(lineHitBox.getX1(), lineHitBox.getY1(), lineHitBox.getX2(), lineHitBox.getY2());
        shapeRendered.end();*/
    }

    public class Wheel {
        private ShapeRenderer shapeRendered = new ShapeRenderer();
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

        private void installationY() {
            rectangle
                    .setY(RoadHitBox.findLineHitBox(wheel.getX(), road)
                            .findY(wheel.getX()));
        }

        public void render() {
            installationY();
            wheel.setPosition(rectangle.x - 3, rectangle.y);
            /*shapeRendered.begin(ShapeRenderer.ShapeType.Line);
            shapeRendered.setColor(0, 1, 0, 1);
            shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            shapeRendered.end();*/
        }

        public void rotateRight() {
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(-rotateWheel);
        }

        public void rotateLeft() {
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(rotateWheel);
        }
    }
}