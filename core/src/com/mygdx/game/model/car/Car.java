package com.mygdx.game.model.car;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Draw;
import com.mygdx.game.model.map.LineHitBox;
import com.mygdx.game.usemodel.map.RoadHitBox;

public class Car implements Draw {
    private Rectangle body;
    private Wheel leftWheel;
    private Wheel rightWheel;
    private Image car;
    private LineHitBox lineHitBox;

    public Car(float x, final float width, final float height) {
        body = new Rectangle(x, RoadHitBox.findLineHitBox(x).findY(x), width, height);
        leftWheel = new Wheel(body.x + 33, 50);
        rightWheel = new Wheel(body.x + body.width - 30 - 50, 50);
        lineHitBox = new LineHitBox(leftWheel.getWheel().getX(), leftWheel.getWheel().getY() + 50, rightWheel.getWheel().getX() + 50, rightWheel.getWheel().getY() + 50);
        car = new Image(new Texture("car.png")) {{
            setPosition(leftWheel.getRectangle().x, leftWheel.getRectangle().y);
            setWidth(width);
            setHeight(height);
        }};
    }

    public Image getCarImage() {
        return car;
    }

    public void moveRight() {
        leftWheel.moveRight();
        rightWheel.moveRight();
    }

    public void moveLeft() {
        leftWheel.moveLeft();
        rightWheel.moveLeft();
    }

    public Wheel getRightWheel() {
        return rightWheel;
    }

    public Wheel getLeftWheel() {
        return leftWheel;
    }

    public void render() {
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

    public class Wheel implements Draw {
        private Rectangle rectangle;
        private Image wheel;

        Wheel(float x, int size) {
            rectangle = new Rectangle(x, RoadHitBox.findLineHitBox(x).findY(x), size, size);
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
            wheel.setPosition(rectangle.x - 3, rectangle.y);
            shapeRendered.begin(ShapeRenderer.ShapeType.Line);
            shapeRendered.setColor(0, 1, 0, 1);
            shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            shapeRendered.end();
        }

        public void moveRight() {
            rectangle.x += 1;
            rectangle
                    .setY(RoadHitBox.findLineHitBox(wheel.getX())
                            .findY(wheel.getX()));
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(-15);
        }

        public void moveLeft() {
            rectangle.x -= 1;
            rectangle
                    .setY(RoadHitBox.findLineHitBox(wheel.getX())
                            .findY(wheel.getX()));
            wheel.setOrigin(wheel.getWidth() / 2, wheel.getHeight() / 2);
            wheel.rotateBy(15);
        }
    }
}