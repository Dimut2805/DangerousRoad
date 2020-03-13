package com.mygdx.game.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Draw;
import com.mygdx.game.usemodel.map.RoadHitBox;


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

    public float[] getLeftPoint() {
        return new float[]{rectangle.x, rectangle.y};
    }

    public float[] getRightPoint() {
        return new float[]{rectangle.x + rectangle.width, rectangle.y};
    }

    public Image getWheel() {
        return wheel;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw() {
        wheel.setPosition(rectangle.x, rectangle.y);
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRendered.end();
    }
}