package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    Car car;
    Map map;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        car = new Car(40, 400, 300, 100);
        map = new Map();
    }

    @Override
    public void render() {
        camera.update();
        map.draw();
        car.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) car.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) car.moveRight();
    }

    @Override
    public void dispose() {
    }
}