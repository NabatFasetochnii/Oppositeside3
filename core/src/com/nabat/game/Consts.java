package com.nabat.game;

import com.badlogic.gdx.Gdx;

public class Consts {

    private final static String LOSE = "You lose";
    private final static String ttfPath = "fonts/Terminus.ttf";
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f;
    private final static String PLAY = "Tap to play";
    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;
    private final static float scaleXY = ((scaleX + scaleY) / 2f);
    private final static String PATH_TO_FIRST = "levels/1/1";

    Consts() {


    }

    public static String getPathToFirst() {
        return PATH_TO_FIRST;
    }

    public static float getScaleXY() {
        return scaleXY;
    }

    public static String getPLAY() {
        return PLAY;
    }

    public static String getLOSE() {
        return LOSE;
    }

    public static String getTtfPath() {
        return ttfPath;
    }

    public static float getScaleX() {
        return scaleX;
    }

    public static float getScaleY() {
        return scaleY;
    }
}
