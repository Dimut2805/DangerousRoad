package com.mygdx.game;

public class RoadHitBox {
    LineHitBox[] lineHitBoxes;

    RoadHitBox() {
        lineHitBoxes = new LineHitBox[]{
                new LineHitBox(0, 200, 200, 200),
                new LineHitBox(200, 200, 300, 300),
                new LineHitBox(300, 300, 500, 300)
        };
    }

    void showRoadHitBox() {
        for (LineHitBox lineHitBox : lineHitBoxes) {
            lineHitBox.showLine();
        }
    }
}
