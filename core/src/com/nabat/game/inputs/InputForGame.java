package com.nabat.game.inputs;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.nabat.game.Consts;
import com.nabat.game.RectZone;
import com.nabat.game.levels.LevelFactory;

import java.util.ArrayList;

public class InputForGame implements InputProcessor {

    ArrayList<ArrayList<RectZone>> arrayLists;
    int i;
    boolean b;
    boolean r;
    int size;
    int[][] points;
    boolean[] touch;
    boolean[][] good;
    LevelFactory levelFactory;

    public InputForGame(LevelFactory levelFactory) {
        this.levelFactory = levelFactory;

        this.arrayLists = levelFactory.getArrayLists();
        this.i = levelFactory.getI();
        this.size = arrayLists.get(i).size();
        points = new int[size][2];
        touch = new boolean[size];
        good = new boolean[size][size];

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

        boolean q = false;
        for (int k = 0; k < size; k++) {

            if (arrayLists.get(i).get(k).isTouch(screenX, Consts.getHEIGHT() - screenY)) {

                q = true;
                break;
            }
        }

        if (q) {

            if (pointer < size) {

                points[pointer][0] = screenX;
                points[pointer][1] = Consts.getHEIGHT() - screenY;
                touch[pointer] = true;

                r = true;
                for (int t = 0; t < size; t++) {

                    r = r && touch[t];
                }
                if (pointer == size - 1 && r) {

                    b = true;
                    for (int j = 0; j < size; j++) {

                        for (int l = 0; l < size; l++) {

                            good[j][l] = arrayLists.get(i).get(j).isTouch(points[l][0], points[l][1]);
                        }
                    }

                    for (int l = 0; l < size; l++) {
                        boolean z = false;
                        for (int j = 0; j < size; j++) {

                            z = z || good[l][j];
                        }
                        if (!z) {
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        levelFactory.setI(i + 1);//TODO написать функцию смены уровня
                        i++;
                        levelFactory.upCountOfSquare();
                    }
                }
            }


        } else {
            levelFactory.upCountOfMiss();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (pointer < size) {
            points[pointer][0] = -1;
            points[pointer][1] = -1;
            touch[pointer] = false;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        /*Vector2 vector21 = new Vector2(screenX, Consts.getHEIGHT() - screenY);
        Vector2 dv = vector2.sub(vector21);
        levelFactory.getCamera().translate(dv);

        vector2 = vector21;*/


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
