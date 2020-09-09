package com.nabat.game.inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.pay.Information;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.levels.Start;
import com.nabat.game.levels.Store;
import de.golfgl.gdxgamesvcs.GameServiceException;

public class InputForStart implements InputProcessor {

    private final MyGame myGame;
    private final RectZone rectZone, gpgsZone;
    private final Start start;
//    private final boolean isAdShow = false;

    public InputForStart(Start start) {

        this.start = start;
        this.myGame = start.getMyGame();
        this.rectZone = start.getStartZone();
        gpgsZone = start.getGpgsZone();
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
        Consts.time = 0;
        int y = Gdx.app.getGraphics().getHeight() - screenY;

        if (rectZone.isTouch(screenX, y)) {

            myGame.setScreen(myGame.getLevels());
            start.dispose();
        }

        if (Consts.isTouch(start.getShopX(), start.getShopY(), start.getShopW(), start.getShopH(), screenX, y)) {


            if (myGame.purchaseManager.installed() &&
                    !myGame.purchaseManager.getInformation(myGame.getSKU()).equals(Information.UNAVAILABLE)) {

                myGame.setScreen(new Store(myGame));
            } else {
                Gdx.input.vibrate(25);
            }

            //TODO SHOP
        }

        if (Consts.isTouch(start.getSoundX(), start.getSoundY(), start.getSoundW(), start.getSoundH(), screenX, y)) {
            Consts.getBool().put(Consts.getSOUND(), !Consts.getBool().get(Consts.getSOUND()));
//            Consts.setSound(!Consts.isSound());
            myGame.changeMusicPlay();
        }

        if (Consts.isTouch(start.getVibX(), start.getVibY(), start.getSoundW(), start.getSoundH(), screenX, y)) {

//            Consts.setVibrate(!Consts.isVibrate());
            Consts.getBool().put(Consts.getVIBRATE(), !Consts.getBool().get(Consts.getVIBRATE()));
        }

        if (gpgsZone.isTouch(screenX, y)) {


            if (myGame.gsClient.isSessionActive()) {
                myGame.gsClient.logOff();
            } else {
                if (!myGame.gsClient.logIn()) {
                    Gdx.app.error("GS_ERROR", "Cannot sign in: No credentials or session id given.");
                }
//                myGame.gsClient.refreshStatusLabel();

            }

//            Consts.setLogin(!Consts.isLogin());
        }

        /*if (Consts.isTouch(start.getRateX(), start.getRateY(), start.getShopW(), start.getShopH(), screenX, y)){

            //TODO ОЦЕНИТЕ ПРИЛОЖУХУ ПЖЖЖЖЖЖЖ
        }*/

        if (Consts.isTouch(start.getAchX(), start.getAchY(), start.getShopW(), start.getShopH(), screenX, y)) {


            try {
                myGame.gsClient.showAchievements();

            } catch (GameServiceException | NullPointerException e) {
                e.printStackTrace();
                Gdx.input.vibrate(25);
            }

        }


        if (Consts.isTouch(start.getLeaderBX(), start.getLeaderBY(), start.getShopW(), start.getShopH(), screenX, y)) {

            try {
                myGame.gsClient.showLeaderboards(Consts.getLEADERBOARD1());

            } catch (GameServiceException | NullPointerException e) {
                e.printStackTrace();
                Gdx.input.vibrate(25);
            }
        }

        if (Consts.isTouch(start.getExitX(), start.getExitY(), start.getShopW(), start.getShopH(), screenX, y)) {

            myGame.updatePref();
            Consts.setRead(true);
            Gdx.app.exit();
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
