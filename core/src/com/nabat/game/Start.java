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
    private final float gpgsW;


    public Start(MyGame myGame) {

        this.myGame = myGame;
        starZone = new RectZone(0, Consts.getHEIGHT() / 2,
                Consts.getWIDTH(), Consts.getHEIGHT() / 2, Color.RED);
        starZone.setPulsar(false);

        GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForMenu(), Consts.getPLAY());
        startW = glyphLayout.width; // получаем ширину текста
        glyphLayout = new GlyphLayout(Consts.getFontForMenu(), Consts.getGPGS()+Consts.getOFF());
        gpgsW = glyphLayout.width;

        gpgsZone = new RectZone((int)(Consts.getWIDTH() / 2f - gpgsW / 2f), (int)(Consts.getHEIGHT() / 3f),
                (int)gpgsW, (int)glyphLayout.height, Color.RED);

        Loader.getShopButton().setU(Consts.getWIDTH() / 20f + Consts.getWIDTH() / 10f);
        Loader.getShopButton().setV(Consts.getHEIGHT() / 5f + Consts.getHEIGHT() / 10f);
        Loader.getShopButton().setU2(Consts.getWIDTH() / 20f);
        Loader.getShopButton().setV2(Consts.getHEIGHT() / 5f);

        Loader.getSoundOn().setU(Consts.getWIDTH() / 20f + Consts.getWIDTH()/5f + Consts.getWIDTH() / 10f);
        Loader.getSoundOn().setV(Consts.getHEIGHT() / 5f + Consts.getHEIGHT() / 10f);
        Loader.getSoundOn().setU2(Consts.getWIDTH() / 20f + Consts.getWIDTH()/5f);
        Loader.getSoundOn().setV2(Consts.getHEIGHT() / 5f);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputForStart(myGame, starZone, gpgsZone));
    }

    @Override
    public void render(float delta) {

        Consts.clear(); //заполняем экран цветом

        starZone.draw(); //большой квадратик сверху
        gpgsZone.draw();//квадратик gpgs

        myGame.getBatch().begin();

        Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getPLAY(),//призыв начать играть
                Consts.getWIDTH() / 2f - startW / 2, Consts.getHEIGHT() * 2 / 3f);

        if (Consts.isLogin()) {

            Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getGPGS() +
                            Consts.getON(), //переключатель аунтификации гугл плэя
                    Consts.getWIDTH() / 2f - gpgsW / 2, Consts.getHEIGHT() / 3f);
        } else {
            Consts.getFontForMenu().draw(myGame.getBatch(), Consts.getGPGS() +
                            Consts.getOFF(), //переключатель аунтификации гугл плэя
                    Consts.getWIDTH() / 2f - gpgsW / 2, Consts.getHEIGHT() / 3f);
        }


        myGame.getBatch().draw(Loader.getShopButton(), // кнопка магазина
                Consts.getWIDTH() / 20f, Consts.getHEIGHT() / 5f,
                Consts.getWIDTH() / 10f, Consts.getWIDTH() / 10f);

        if (Consts.isSound()) { // переключатель музыки

            myGame.getBatch().draw(Loader.getSoundOn(),
                    Consts.getWIDTH() / 20f + Consts.getWIDTH()/5f, Consts.getHEIGHT() / 5f,
                    Consts.getWIDTH() / 10f, Consts.getWIDTH() / 10f);
        } else {

            myGame.getBatch().draw(Loader.getSoundOff(),
                    Consts.getWIDTH() / 20f + Consts.getWIDTH()/5f, Consts.getHEIGHT() / 5f,
                    Consts.getWIDTH() / 10f, Consts.getWIDTH() / 10f);
        }



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
}
