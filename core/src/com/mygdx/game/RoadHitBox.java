package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.mygdx.game.Draw.shapeRendered;

public class RoadHitBox {
    private LineHitBox[] lineHitBoxes;
    private Car car;

    RoadHitBox(Car car) {
        this.car = car;
        lineHitBoxes = new LineHitBox[]{
                new LineHitBox(0, 150, 200, 200),
                new LineHitBox(200, 200, 240, 300),
                new LineHitBox(240, 300, 500, 400)
        };
    }

    void showRoadHitBox() {
        for (LineHitBox lineHitBox : lineHitBoxes) {
            lineHitBox.showLine();
        }
    }

    public LineHitBox[] getLineHitBoxes() {
        return lineHitBoxes;
    }
}
