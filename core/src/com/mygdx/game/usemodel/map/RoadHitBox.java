package com.mygdx.game.usemodel.map;

import com.mygdx.game.model.map.LineHitBox;

public class RoadHitBox {

    public static LineHitBox[] getLinesHitBoxes() {
        return new LineHitBox[]{
                new LineHitBox(100, 250, 200, 261),
                new LineHitBox(200, 261, 285, 250),
                new LineHitBox(285, 250, 430, 210),
                new LineHitBox(430, 210, 500, 193),
                new LineHitBox(500, 193, 700, 215)
        };
    }

    public static void showRoadHitBox() {
        for (LineHitBox lineHitBox : getLinesHitBoxes()) {
            lineHitBox.showLine();
        }
    }

    public static LineHitBox findLineHitBox(float x) {
        for (LineHitBox lineHitBox : getLinesHitBoxes()) {
            if (x >= lineHitBox.getX1() && x <= lineHitBox.getX2()) {
                return lineHitBox;
            }
        }
        return null;
    }
}