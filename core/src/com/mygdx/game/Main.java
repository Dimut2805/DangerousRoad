package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Stage stage;
    private Car car;
    private Map map;
    private Pedal leftPedal;
    private Pedal rightPedal;
    private RoadHitBox roadHitBox;
    RelationshipCar relationshipCar;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        relationshipCar = new RelationshipCar(40, 400, 300, 100);
        map = new Map();
        roadHitBox = new RoadHitBox(car);
        leftPedal = new Pedal(10, 10, 50, 150);
        rightPedal = new Pedal(Gdx.graphics.getWidth() - 60, 10, 50, 150);
    }

    @Override
    public void render() {
        Gdx.graphics.getGL20().glClearColor(1, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        map.draw();
        roadHitBox.showRoadHitBox();
        relationshipCar.drawCar();
        relationshipCar.overlapWheel(roadHitBox.getLineHitBoxes());
        stage.addActor(relationshipCar.getCar().getLeftWheel().getWheel());
        stage.addActor(relationshipCar.getCar().getRightWheel().getWheel());
        stage.draw();
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Rectangle touchRectable = new Rectangle(touchPos.x, touchPos.y, 10, 10);
            if (touchRectable.overlaps(leftPedal.getRectangle())) {
                relationshipCar.moveLeft();
            }
            System.out.println(touchRectable.contains(rightPedal.getRectangle()));
            if (rightPedal.getRectangle().contains(touchRectable)) {
                relationshipCar.moveRight();
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) relationshipCar.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) relationshipCar.moveRight();
    }

    @Override
    public void dispose() {
    }
}