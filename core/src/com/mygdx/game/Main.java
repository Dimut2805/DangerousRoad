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

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Stage stage;
    private Map map;
    private Car car;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(100, 100);
        car = new Car(110, 300, 100);
        map = new Map();
    }

    @Override
    public void render() {
        Gdx.graphics.getGL20().glClearColor(1, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        map.draw();
        RoadHitBox.showRoadHitBox();
        car.render();
        stage.addActor(car.getCarImage());
        stage.addActor(car.getLeftWheel().getWheel());
        stage.addActor(car.getRightWheel().getWheel());
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
    }

    @Override
    public void dispose() {
    }
}