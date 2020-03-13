package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.map.Map;
import com.mygdx.game.usemodel.car.RelationshipCar;
import com.mygdx.game.usemodel.map.RoadHitBox;

import java.awt.Rectangle;

import javax.swing.Spring;

import static com.mygdx.game.Draw.batch;
import static sun.audio.AudioPlayer.player;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Stage stage;
    private Map map;
    private RelationshipCar relationshipCar;
    private Sprite sprite;


    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        relationshipCar = new RelationshipCar(110, 300, 100);
        map = new Map();
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        Gdx.graphics.getGL20().glClearColor(1, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        map.draw();
        RoadHitBox.showRoadHitBox();
        relationshipCar.drawCar();
        stage.addActor(relationshipCar.getCar().getCarImage());
        stage.addActor(relationshipCar.getCar().getLeftWheel().getWheel());
        stage.addActor(relationshipCar.getCar().getRightWheel().getWheel());
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) relationshipCar.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) relationshipCar.moveRight();

        if (camera.position.x < relationshipCar.getCar().getLeftWheel().getRectangle().x) {
            camera.position.set(relationshipCar.getCar().getLeftWheel().getRectangle().x, camera.position.y,0);
            stage.getCamera().update();
        }
        if (camera.position.x > (relationshipCar.getCar().getLeftWheel().getRectangle().x)) {
            camera.position.set(-(relationshipCar.getCar().getLeftWheel().getRectangle().x), camera.position.y,0);
            stage.getCamera().update();
        }
        if (camera.position.y < (relationshipCar.getCar().getLeftWheel().getRectangle().y)) {
            camera.position.set(camera.position.x, relationshipCar.getCar().getLeftWheel().getRectangle().y,0);
            stage.getCamera().update();
        }
        if (camera.position.y > (relationshipCar.getCar().getLeftWheel().getRectangle().y)) {
            camera.position.set(camera.position.x, -(relationshipCar.getCar().getLeftWheel().getRectangle().y),0);
            stage.getCamera().update();
        }

    }


    @Override
    public void dispose() {
    }
}