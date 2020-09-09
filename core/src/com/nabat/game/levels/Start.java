package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.nabat.game.Consts;
import com.nabat.game.Loader;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForStart;

public class Start implements Screen {

    private final RectZone startZone, gpgsZone;
    private final MyGame myGame;
    private final float startW;
    private final float gpgsW, gpgsH;
    private final float soundX, soundY, soundW, soundH;
    private final float shopX, shopY, shopW, shopH;
    //    private final float rateX, rateY;
    private final float exitX, exitY;
    private final float vibX, vibY;
    private final float achX, achY;
    private final float leaderBX, leaderBY;
//    private final float size = Consts.getWIDTH() / 2f;
    private String onOff;
    private int time = 0;
    private boolean isInput = true;

    public Start(MyGame myGame) {

        this.myGame = myGame;

        startZone = new RectZone(0, Gdx.app.getGraphics().getHeight() / 2,
                Consts.getWIDTH(), Gdx.app.getGraphics().getHeight(), Color.RED);
        startZone.setPulsar(false);

        GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForMenu(), Consts.getPLAY());
        startW = glyphLayout.width; // получаем ширину текста
        glyphLayout = new GlyphLayout(Consts.getFontForMenu(), Consts.getGPGS() + Consts.getOFF());
        gpgsW = glyphLayout.width;
        gpgsH = glyphLayout.height;
        int delta = Consts.getWIDTH() / 50;
        gpgsZone = new RectZone((int) (Consts.getWIDTH() / 2f - gpgsW / 2f) - delta,
                (int) (Consts.getHEIGHT() / 3f) - delta,
                (int) gpgsW + 2 * delta, (int) gpgsH + 2 * delta, Color.RED);

        shopW = Consts.getWIDTH() / 10f;
        shopH = shopW;
        shopX = gpgsZone.getX() + gpgsZone.getWidth() / 2f - shopW * 3f - delta * 2f;
        shopY = gpgsZone.getY() - shopH - delta * 2;

        soundX = shopX + shopW + delta;
        soundY = shopY;
        soundW = shopW;
        soundH = shopW;

        /*rateX = soundX + shopW + delta;
        rateY = shopY;*/

        vibX = soundX + shopW + delta;
        vibY = shopY;

        achX = vibX + shopW + delta;
        achY = shopY;

        leaderBX = achX + shopW + delta;
        leaderBY = shopY;

        exitX = leaderBX + shopW + delta;//rateX + shopW + delta;
        exitY = shopY;//shopY;

    }


    public float getAchX() {
        return achX;
    }

    public float getAchY() {
        return achY;
    }

    public float getLeaderBX() {
        return leaderBX;
    }

    public float getLeaderBY() {
        return leaderBY;
    }

    public float getVibX() {
        return vibX;
    }

    public float getVibY() {
        return vibY;
    }

    @Override
    public void show() {
        if (Consts.getBool().get(Consts.getIsFirst())) {
            Consts.getBool().put(Consts.getIsFirst(), false);
        } else {
            myGame.gsClient.unlockAchievement(Consts.getIsItYouAgain());
        }
        Consts.getMap().put(Consts.getImAtHome(), Consts.getMap().get(Consts.getImAtHome()) + 1);
        if (Consts.getMap().get(Consts.getImAtHome()) <= 421) {

            myGame.gsClient.incrementAchievement(Consts.getImAtHome(), 1, Consts.getMap().get(Consts.getImAtHome()) / 421f);
        }

    }

    @Override
    public void render(float delta) {

        Consts.clear(); //заполняем экран цветом

        if (isInput) {

            if (time > 20) {
                Gdx.input.setInputProcessor(new InputForStart(this));
                isInput = false;
                time = 0;

            } else {
                time++;
            }
        }


        startZone.draw(); //большой квадратик сверху
        gpgsZone.draw();//квадратик gpgs

        myGame.getBatch().begin();
        Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getPLAY(),//призыв начать играть
                Consts.getWIDTH() / 2f - startW / 2, Consts.getHEIGHT() * 3 / 4f);

        if (myGame.gsClient.isSessionActive()) {

            onOff = Consts.getGPGS() + Consts.getON();

        } else if (myGame.gsClient.isConnectionPending()) {

            onOff = Consts.getGPGS() + "...";
        } else {
            onOff = Consts.getGPGS() + Consts.getOFF();

        }
        Consts.getFontForMenu().draw(myGame.getBatch(), onOff, //переключатель аунтификации гугл плэя
                Consts.getWIDTH() / 2f - gpgsW / 2, Consts.getHEIGHT() / 3f + gpgsH);

        myGame.getBatch().draw(Loader.getShopButton(), // кнопка магазина
                shopX, shopY,
                shopW, shopH);

        if (Consts.getBool().get(Consts.getSOUND())) { // переключатель музыки

            myGame.getBatch().draw(Loader.getSoundOn(),
                    soundX, soundY,
                    soundW, soundH);
        } else {

            myGame.getBatch().draw(Loader.getSoundOff(),
                    soundX, soundY,
                    soundW, soundH);
        }
        if (Consts.getBool().get(Consts.getVIBRATE())) {
            myGame.getBatch().draw(Loader.getVibrateButton(), vibX, vibY, shopW, shopH);
        } else {
            myGame.getBatch().draw(Loader.getNoVibrateButton(), vibX, vibY, shopW, shopH);
        }

        /*myGame.getBatch().draw(Loader.getRateButton(), rateX, rateY, //кнопка оценки приложения
                shopW, shopH);*/

        myGame.getBatch().draw(Loader.getExitButton(), exitX, exitY, shopW, shopH);
        myGame.getBatch().draw(Loader.getAchievementsButton(), achX, achY, shopW, shopH);
        myGame.getBatch().draw(Loader.getLeaderBoardButton(), leaderBX, leaderBY, shopW, shopH);


        myGame.getBatch().end();


    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        startZone.dispose();
    }

    public float getExitX() {
        return exitX;
    }

    public float getExitY() {
        return exitY;
    }

//    public float getRateX() {
//        return rateX;
//    }
//
//    public float getRateY() {
//        return rateY;
//    }

    public float getShopX() {
        return shopX;
    }

    public float getShopY() {
        return shopY;
    }

    public float getShopW() {
        return shopW;
    }

    public float getShopH() {
        return shopH;
    }

    public RectZone getStartZone() {
        return startZone;
    }

    public RectZone getGpgsZone() {
        return gpgsZone;
    }

    public float getSoundX() {
        return soundX;
    }

    public float getSoundY() {
        return soundY;
    }

    public float getSoundW() {
        return soundW;
    }

    public float getSoundH() {
        return soundH;
    }

    public MyGame getMyGame() {
        return myGame;
    }
}
