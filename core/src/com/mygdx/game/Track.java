package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Track {
    Music music;

    Track(String path) {
        music = Gdx.audio.newMusic(Gdx.files.internal(path));
        music.setVolume((float) 0.4);
    }

    void play() {
        music.setLooping(true);
        music.play();
    }
}
