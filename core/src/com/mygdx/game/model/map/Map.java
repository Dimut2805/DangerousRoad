package com.mygdx.game.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Draw;

public class Map implements Draw {
    private Texture mapTexture;

    public Map() {
        mapTexture = new Texture("road.png");
    }

    public void draw() {
        batch.begin();
        batch.draw(mapTexture, 0, -100,8000,1000);
        batch.end();
    }
}
