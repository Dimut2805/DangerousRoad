package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Map implements Draw {
    private Texture mapTexture;

    Map() {
        mapTexture = new Texture("road.jpg");
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(mapTexture, 0, 0);
        batch.end();
    }
}
