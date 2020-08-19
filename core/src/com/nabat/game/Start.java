package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.nabat.game.inputs.InputForStart;

public class Start implements Screen {

    private final RectZone starZone, gpgsZone;
    private final MyGame myGame;
    private final float startW;
    private final float gpgsW, gpgsH;
    private final float soundX, soundY, soundW, soundH;
    private final float shopX, shopY, shopW, shopH;
    private final float rateX, rateY;
    private final float exitX, exitY;

    public Start(MyGame myGame) {

        this.myGame = myGame;

        starZone = new RectZone(0, Consts.getHEIGHT() / 2,
                Consts.getWIDTH(), Consts.getHEIGHT() / 2, Color.RED);
        starZone.setPulsar(false);

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
        shopX = gpgsZone.getX() + gpgsZone.getWidth()/2f - shopW*2 - delta*3/2f;
        shopY = gpgsZone.getY() - shopH - delta * 2;

        soundX = shopX + shopW + delta;
        soundY = shopY;
        soundW = shopW;
        soundH = shopW;

        rateX = soundX + shopW + delta;
//        rateX = gpgsZone.getX() + gpgsW/2 + delta*2f;
        rateY = shopY;

        exitX = rateX + shopW + delta;
        exitY = shopY;

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputForStart(this));
    }

    @Override
    public void render(float delta) {

        Consts.clear(); //заполняем экран цветом

        starZone.draw(); //большой квадратик сверху
        gpgsZone.draw();//квадратик gpgs

        myGame.getBatch().begin();

        Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getPLAY(),//призыв начать играть
                Consts.getWIDTH() / 2f - startW / 2, Consts.getHEIGHT() * 3 / 4f);

        if (myGame.gsClient.isSessionActive()) {

            Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getGPGS() +
                            Consts.getON(), //переключатель аунтификации гугл плэя
                    Consts.getWIDTH() / 2f - gpgsW / 2, Consts.getHEIGHT() / 3f + gpgsH);
        } else {
            Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getGPGS() +
                            Consts.getOFF(), //переключатель аунтификации гугл плэя
                    Consts.getWIDTH() / 2f - gpgsW / 2, Consts.getHEIGHT() / 3f + gpgsH);
        }


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
        starZone.dispose();
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

    public RectZone getStarZone() {
        return starZone;
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
