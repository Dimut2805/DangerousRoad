package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Map implements Draw {
    private Texture mapTexture;

    Map() {
        mapTexture = new Texture("roadCYS.png");
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(mapTexture, 0, -100,8000,1000);
        batch.end();
    }
}
