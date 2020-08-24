package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.nabat.game.inputs.InputForStart;

public class Start implements Screen {

    private final RectZone startZone, gpgsZone;
    private final MyGame myGame;
    private final float startW;
    private final float gpgsW, gpgsH;
    private final float soundX, soundY, soundW, soundH;
    private final float shopX, shopY, shopW, shopH;
    private final float rateX, rateY;
    private final float exitX, exitY;
    private final float vibX, vibY;
    private String onOff;

    public Start(MyGame myGame) {

        this.myGame = myGame;

        startZone = new RectZone(0, Consts.getHEIGHT() / 2,
                Consts.getWIDTH(), Consts.getHEIGHT() / 2, Color.RED);
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
        shopX = gpgsZone.getX() + gpgsZone.getWidth() / 2f - shopW * 5 / 2f - delta * 3 / 2f;
        shopY = gpgsZone.getY() - shopH - delta * 2;

        soundX = shopX + shopW + delta;
        soundY = shopY;
        soundW = shopW;
        soundH = shopW;

        rateX = soundX + shopW + delta;
        rateY = shopY;

        vibX = rateX + shopW + delta;
        vibY = shopY;

        exitX = vibX + shopW + delta;//rateX + shopW + delta;
        exitY = shopY;//shopY;


    }

    public float getVibX() {
        return vibX;
    }

    public float getVibY() {
        return vibY;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputForStart(this));
    }

    @Override
    public void render(float delta) {

        Consts.clear(); //заполняем экран цветом

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

        if (Consts.isSound()) { // переключатель музыки

            myGame.getBatch().draw(Loader.getSoundOn(),
                    soundX, soundY,
                    soundW, soundH);
        } else {

            myGame.getBatch().draw(Loader.getSoundOff(),
                    soundX, soundY,
                    soundW, soundH);
        }

        if (Consts.isVibrate()) {
            myGame.getBatch().draw(Loader.getVibrateButton(), vibX, vibY, shopW, shopH);
        } else {
            myGame.getBatch().draw(Loader.getNoVibrateButton(), vibX, vibY, shopW, shopH);
        }

        myGame.getBatch().draw(Loader.getRateButton(), rateX, rateY, //кнопка оценки приложения
                shopW, shopH);

        myGame.getBatch().draw(Loader.getExitButton(), exitX, exitY, shopW, shopH);

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

    public float getRateX() {
        return rateX;
    }

    public float getRateY() {
        return rateY;
    }

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
