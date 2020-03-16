package com.mygdx.game.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Draw;

public class Map implements Draw {
    private Texture mapTexture;

    public Map() {
        mapTexture = new Texture("road.png");
    }

    public void render() {
        batch.begin();
        batch.draw(mapTexture, 0, -65, 6000,900);
        batch.end();
    }
}
