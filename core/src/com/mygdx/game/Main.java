package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Car car;
    private Map map;
    private Pedal leftPedal;
    private Pedal rightPedal;
    private Texture moveBack;
    private Batch batch;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        car = new Car(40, 400, 300, 100);
        map = new Map();
        leftPedal = new Pedal(10, 10, 50, 150);
        rightPedal = new Pedal(Gdx.graphics.getWidth() - 60, 10, 50, 150);
        moveBack = new Texture("moveback.jpg");
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        camera.update();
        map.draw();
        car.draw();
        batch.begin();
        leftPedal.draw();
        rightPedal.draw();
        batch.end();
        if (!car.getLeftWheel().onLand()) {
            car.drop();
        }
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Rectangle touchRectable = new Rectangle(touchPos.x, touchPos.y, 10, 10);
            if(touchRectable.overlaps(leftPedal.getRectangle())) {
                car.moveLeft();
            }
            System.out.println(touchRectable.contains(rightPedal.getRectangle()));
            if(rightPedal.getRectangle().contains(touchRectable)) {
                car.moveRight();
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
    }

    @Override
    public void dispose() {
    }
}