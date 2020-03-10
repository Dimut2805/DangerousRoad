package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Map implements Draw {
    private Texture mapTexture;

    Map() {
        mapTexture = new Texture("road.png");
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(mapTexture, 300, 300, 300,300);
        batch.end();
    }
}
