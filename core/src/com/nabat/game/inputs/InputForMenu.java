package com.nabat.game.inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.nabat.game.Consts;
import com.nabat.game.levels.Levels;

public class InputForMenu implements InputProcessor {

Levels levels;
    public InputForMenu(Levels levels) {
        this.levels = levels;

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

        if (levels.getL1().isTouch(screenX, Consts.getHEIGHT()-screenY)){

            Levels.setLvl(1);
        }
        if (levels.getL2().isTouch(screenX, Consts.getHEIGHT()-screenY)){

            Levels.setLvl(2);
        }

        if (levels.getL3().isTouch(screenX, Consts.getHEIGHT()-screenY)){

            Levels.setLvl(3);
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
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
