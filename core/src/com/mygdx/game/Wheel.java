package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class Wheel implements Draw {
    private TextureRegion textureRegion;
    private Rectangle rectangle;
    Stage stage;

    Wheel(float x, float y, int size) {
        stage = new Stage(new ScreenViewport());
        rectangle = new Rectangle(x, y, size, size);
        Image wheel = new Image(new Texture("wheel.png")) {{
            setPosition(rectangle.x, rectangle.y);
            setWidth(rectangle.width);
            setHeight(rectangle.height);
        }};
        stage.addActor(wheel);
    }

    boolean onLand() {
        return rectangle.y <= 130;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw() {
        stage.draw();
        shapeRendered.begin(ShapeRenderer.ShapeType.Line);
        shapeRendered.setColor(0, 1, 0, 1);
        shapeRendered.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRendered.end();
    }
}