package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.car.Car;
import com.mygdx.game.model.map.Road;
import com.mygdx.game.model.car.Pedal;
import com.mygdx.game.usemodel.map.RoadHitBox;

public class Main extends ApplicationAdapter {
    private Stage carStage;
    private Pedal pedal;
    private Car car;
    private Road road;
    private MyInput myInput;
    private Obstacles obstacles;
    private Vector3 touchPos = new Vector3();

    @Override
    public void create() {
        carStage = new Stage(new ScreenViewport());
        road = new Road();
        car = new Car(200, 300, 100, road);
        myInput = new MyInput(car);
        Gdx.input.setInputProcessor(myInput);
        obstacles = new Obstacles(car);
        pedal = new Pedal();
        new Track("Пчеловод.mp3").play();
    }

    private void buildCar() {
        carStage.addActor(car.getCarImage());
        carStage.addActor(car.getLeftWheel().getWheel());
        carStage.addActor(car.getRightWheel().getWheel());
    }

    @Override
    public void render() {
        if (Finish.isFinish(car, road)) {
            System.out.println("Игра пройдена");
            // TODO: 28.03.2020
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
        Gdx.gl.glClearColor(0, 235, 103, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        RoadHitBox.showRoadHitBox(road);
        car.render();
        buildCar();
        carStage.draw();
        obstacles.render();
        if (Gdx.input.isTouched()) {
            touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            pedal.move(touchPos,car);
        }
        pedal.render();
    }


    @Override
    public void dispose() {
    }
}