package com.nabat.game;

import com.badlogic.gdx.Gdx;

public class Consts {

    private final static String LOSE = "You lose";
    private final static String ttfPath = "fonts/Terminus.ttf";
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f;

    public static String getPLAY() {
        return PLAY;
    }

    private final static String PLAY = "Tap to play";

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

    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;

    Consts() {



    }
}
