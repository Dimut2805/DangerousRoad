package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.model.car.Car;

public class MyInput implements InputProcessor {
    private Car car;

    MyInput(Car car) {
        this.car = car;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                car.setIsLeft(true);
                car.setIsMove(true);
                break;
            case Input.Keys.RIGHT:
                car.setIsRight(true);
                car.setIsMove(true);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                car.setIsMove(false);
                car.setSpeed(0);
                break;
            case Input.Keys.RIGHT:
                car.setIsMove(false);
                car.setSpeed(0);
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
