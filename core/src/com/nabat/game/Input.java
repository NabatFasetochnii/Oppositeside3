package com.nabat.game;

import com.badlogic.gdx.InputProcessor;
import com.nabat.game.levels.Lvl1;
import java.util.ArrayList;

public class Input implements InputProcessor {

    ArrayList<ArrayList<RectZone>> arrayLists;
    int i;
    boolean b;
    boolean r;
    int size;
    int[][] points;
    boolean[] touch;
    Lvl1 lvl1;

    Input(Lvl1 lvl1) {
        this.lvl1 = lvl1;

        this.arrayLists = lvl1.getArrayLists();
        this.i = lvl1.getI();
        this.size = arrayLists.get(i).size();
        points = new int[size][2];
        touch = new boolean[size];

    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        if (pointer<size){//TODO пофиксить

            points[pointer][0] = screenX;
            points[pointer][1] = screenX;
            touch[pointer] = true;

            r = true;
            for (int t = 0;t < size; t++){

                r = r&&touch[t];
            }
            if (pointer == size-1 && r){

                b = true;
                for (int j = 0; j < size; j++) {

                    b = b && arrayLists.get(i).get(j).isTouch(points[j][0], points[j][1]);

                }
                if (b){
                    lvl1.setI(i++);//TODO написать функцию смены уровня
                }
            }
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (pointer<size){
            points[pointer][0] = -1;
            points[pointer][1] = -1;
            touch[pointer] = false;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }


    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
