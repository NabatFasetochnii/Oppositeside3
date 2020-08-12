package com.nabat.game.inputs;

import com.badlogic.gdx.InputProcessor;
import com.nabat.game.Consts;
import com.nabat.game.levels.Levels;

public class InputForMenu implements InputProcessor {

    Levels levels;
    int scrollX;
    int scroll;

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

        scrollX = screenX;

        ////////////////////////////////////////////////////////////////////////
        if (levels.getL1().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(1);
        }
        if (levels.getL2().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(2);
        }
        if (levels.getL3().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(3);
        }
        if (levels.getL4().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(4);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL1R().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(10);
        }
        if (levels.getL2R().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(20);
        }
        if (levels.getL3R().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(30);
        }
        if (levels.getL4R().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(40);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL1R1().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(101);
        }
        if (levels.getL2R1().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(201);
        }
        if (levels.getL3R1().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(301);
        }
        if (levels.getL4R1().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(401);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL1R2().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(102);
        }
        if (levels.getL2R2().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(202);
        }
        if (levels.getL3R2().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(302);
        }
        if (levels.getL4R2().isTouch(screenX, Consts.getHEIGHT() - screenY)) {
            Levels.setLvl(402);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL11().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(11);
        }
        if (levels.getL21().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(21);
        }
        if (levels.getL31().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(31);
        }
        if (levels.getL41().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(41);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL12().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(12);
        }
        if (levels.getL22().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(22);
        }
        if (levels.getL32().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(32);
        }
        if (levels.getL42().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(42);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL121().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(121);
        }
        if (levels.getL221().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(221);
        }
        if (levels.getL321().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(321);
        }
        if (levels.getL421().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(421);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL122().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(122);
        }
        if (levels.getL222().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(222);
        }
        if (levels.getL322().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(322);
        }
        if (levels.getL422().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(422);
        }
        ////////////////////////////////////////////////////////////////////////
        if (levels.getL111().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(111);
        }
        if (levels.getL211().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(211);
        }
        if (levels.getL311().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(311);
        }
        if (levels.getL411().isTouch(screenX, Consts.getHEIGHT() - screenY)) {

            Levels.setLvl(411);
        }
        ////////////////////////////////////////////////////////////////////////

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        int dx = screenX - scrollX;

        scroll = (levels.getScrollX() - dx) / 2;
        levels.setScrollX(scroll);

        scrollX = screenX;

        return true;
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
