package com.mygdx.game.model.car;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Draw;

public class Pedals implements Draw {

    private Skin PEDAL = new Skin(FileHandle.tempFile("Pedal.png"));
    private Skin PEDAL2 = new Skin(FileHandle.tempFile("Pedal2.png"));

    private ImageButton pedalL;
    private ImageButton pedalR;

    public Pedals pedalLeft(final float x, final float y, final int size) {
        pedalL = new ImageButton(PEDAL){
            {
                setPosition(x, y);
                setSize(size-40,size);
                addListener(new InputListener(){

                });
            }
        };
        return null;
    }
    public Pedals pedalRight(final float x, final float y, final int size){
        pedalR = new ImageButton(PEDAL2) {
            {
                setPosition(x,y);
                setSize(size-40,size);
            }
        };
        return null;
    }

    public ImageButton getPedalL() {
        return pedalL;
    }

    public ImageButton getPedalR() {
        return pedalR;
    }
}
