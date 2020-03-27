package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.car.Car;
import com.mygdx.game.model.car.Pedals;
import com.mygdx.game.model.map.Map;
import com.mygdx.game.usemodel.map.RoadHitBox;

import static com.mygdx.game.Draw.batch;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Stage carStage;
    private Stage pedalLeftStage;
    private Stage pedalRightStage;
    private Map map;
    private Car car;
    private Pedals pedalLeft;
    private Pedals pedalRight;
    @Override
    public void create() {
        carStage = new Stage(new ScreenViewport());
        pedalLeftStage = new Stage(new ScreenViewport());
        pedalRightStage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(100, 100);
        car = new Car(110, 300, 100);
        map = new Map();
        pedalLeft = new Pedals().pedalLeft(50,1,150);
        pedalRight = new Pedals().pedalRight(500,1,150);
    }

    @Override
    public void render() {
        camera.position.set(car.getRightWheel().getRectangle().x, car.getRightWheel().getRectangle().y,0);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
        camera.position.set(car.getRightWheel().getRectangle().x, car.getRightWheel().getRectangle().y, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        map.render();
        RoadHitBox.showRoadHitBox();
        car.render();
        pedalLeftStage.addActor(pedalLeft.getPedalL());
        pedalRightStage.addActor(pedalRight.getPedalR());
        carStage.addActor(car.getCarImage());
        carStage.addActor(car.getLeftWheel().getWheel());
        carStage.addActor(car.getRightWheel().getWheel());
        carStage.draw();
        pedalRightStage.draw();
        pedalLeftStage.draw();
    }


    @Override
    public void dispose() {
    }
}