package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.car.Car;
import com.mygdx.game.model.map.Map;
import com.mygdx.game.usemodel.map.RoadHitBox;

import static com.mygdx.game.Draw.batch;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Stage carStage;
    private Map map;
    private Car car;

    @Override
    public void create() {
        carStage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(100, 100);
        car = new Car(110, 300, 100);
        map = new Map();
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft(camera);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight(camera);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        map.render();
        RoadHitBox.showRoadHitBox();
        car.render();
        carStage.addActor(car.getCarImage());
        carStage.addActor(car.getLeftWheel().getWheel());
        carStage.addActor(car.getRightWheel().getWheel());
        carStage.draw();
    }


    @Override
    public void dispose() {
    }
}