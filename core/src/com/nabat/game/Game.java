package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nabat.game.levels.Levels;

public class Game extends com.badlogic.gdx.Game { //TODO реализовать логгер

    private Levels levels;
    private SpriteBatch batch;
    private Preferences preferences;

    @Override
    public void create() {

        preferences = Gdx.app.getPreferences(Consts.getPrefName());

        Consts.setCountOfAllPoints(preferences.getInteger(Consts.getCOUNT0()));//сохранение прогресса
        //
        Consts.setCountOfPoints1(preferences.getInteger(Consts.getCOUNT1()));
        Consts.setCountOfPoints2(preferences.getInteger(Consts.getCOUNT2()));
        Consts.setCountOfPoints3(preferences.getInteger(Consts.getCOUNT3()));
        Consts.setCountOfPoints4(preferences.getInteger(Consts.getCOUNT4()));
        //
        Consts.setCountOfPoints11(preferences.getInteger(Consts.getCOUNT11()));
        Consts.setCountOfPoints21(preferences.getInteger(Consts.getCOUNT21()));
        Consts.setCountOfPoints31(preferences.getInteger(Consts.getCOUNT31()));
        Consts.setCountOfPoints41(preferences.getInteger(Consts.getCOUNT41()));
        //
        Consts.setCountOfPoints12(preferences.getInteger(Consts.getCOUNT12()));
        Consts.setCountOfPoints22(preferences.getInteger(Consts.getCOUNT22()));
        Consts.setCountOfPoints32(preferences.getInteger(Consts.getCOUNT32()));
        Consts.setCountOfPoints42(preferences.getInteger(Consts.getCOUNT42()));
        //
        Consts.setCountOfPoints1R(preferences.getInteger(Consts.getCOUNT1R()));
        Consts.setCountOfPoints2R(preferences.getInteger(Consts.getCOUNT2R()));
        Consts.setCountOfPoints3R(preferences.getInteger(Consts.getCOUNT3R()));
        Consts.setCountOfPoints4R(preferences.getInteger(Consts.getCOUNT4R()));
        batch = new SpriteBatch();
        levels = new Levels(this);
        Loader.load();

        setScreen(levels);
    }


    @Override
    public void render() {

        super.render();
    }

    public void updatePref() {

        preferences.putInteger(Consts.getCOUNT0(), Consts.getCountOfAllPoints());
        //
        preferences.putInteger(Consts.getCOUNT1(), Consts.getCountOfPoints1());
        preferences.putInteger(Consts.getCOUNT2(), Consts.getCountOfPoints2());
        preferences.putInteger(Consts.getCOUNT3(), Consts.getCountOfPoints3());
        preferences.putInteger(Consts.getCOUNT4(), Consts.getCountOfPoints4());
        //
        preferences.putInteger(Consts.getCOUNT11(), Consts.getCountOfPoints11());
        preferences.putInteger(Consts.getCOUNT21(), Consts.getCountOfPoints21());
        preferences.putInteger(Consts.getCOUNT31(), Consts.getCountOfPoints31());
        preferences.putInteger(Consts.getCOUNT41(), Consts.getCountOfPoints41());
        //
        preferences.putInteger(Consts.getCOUNT12(), Consts.getCountOfPoints12());
        preferences.putInteger(Consts.getCOUNT22(), Consts.getCountOfPoints22());
        preferences.putInteger(Consts.getCOUNT32(), Consts.getCountOfPoints32());
        preferences.putInteger(Consts.getCOUNT42(), Consts.getCountOfPoints42());
        //
        preferences.putInteger(Consts.getCOUNT1R(), Consts.getCountOfPoints1R());
        preferences.putInteger(Consts.getCOUNT2R(), Consts.getCountOfPoints2R());
        preferences.putInteger(Consts.getCOUNT3R(), Consts.getCountOfPoints3R());
        preferences.putInteger(Consts.getCOUNT4R(), Consts.getCountOfPoints4R());

        preferences.flush();
    }


    public Levels getLevels() {
        return levels;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void dispose() {

        updatePref();


        //l0.dispose();
        levels.dispose();
        Loader.dispose();
    }
}
