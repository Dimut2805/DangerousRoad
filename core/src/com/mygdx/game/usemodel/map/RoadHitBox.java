package com.mygdx.game.usemodel.map;

import com.mygdx.game.model.map.LineHitBox;
import com.mygdx.game.model.map.Road;

public class RoadHitBox {

    public static void showRoadHitBox(Road road) {
        for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
            lineHitBox.showLine();
        }
    }

    public static LineHitBox findLineHitBox(float x, Road road) {
        for (LineHitBox lineHitBox : road.getLineHitBoxes()) {
            if (x >= lineHitBox.getX1() && x <= lineHitBox.getX2()) {
                return lineHitBox;
            }
        }
        return null;
    }
}