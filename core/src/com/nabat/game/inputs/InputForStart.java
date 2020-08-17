package com.nabat.game.inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.nabat.game.Consts;
import com.nabat.game.Loader;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;

public class InputForStart implements InputProcessor {

    private final MyGame myGame;
    private final RectZone rectZone, gpgsZone;

    public InputForStart(MyGame myGame, RectZone rectZone, RectZone gpgs) {

        this.myGame = myGame;
        this.rectZone = rectZone;
        gpgsZone = gpgs;
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        int y = Consts.getHEIGHT() - screenY;

        if (rectZone.isTouch(screenX, y)){

            myGame.setScreen(myGame.getLevels());
        }
        if (Consts.isTouch(Loader.getShopButton(), screenX,y)){

            //TODO SHOP
        }
        if (Consts.isTouch(Loader.getSoundOn(), screenX, y)){
            Consts.setSound(!Consts.isSound());
        }
        if (gpgsZone.isTouch(screenX, y)){

            //TODO LOGIN
            if (myGame.gsClient.isSessionActive())
                myGame.gsClient.logOff();
            else {
                if (!myGame.gsClient.logIn())
                    Gdx.app.error("GS_ERROR", "Cannot sign in: No credentials or session id given.");

                //refreshStatusLabel();
            }

            Consts.setLogin(!Consts.isLogin());
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
