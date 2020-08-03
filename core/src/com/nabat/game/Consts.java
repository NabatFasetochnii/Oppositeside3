package com.nabat.game;

import com.badlogic.gdx.Gdx;

public class Consts {

    private final static String LOSE = "You lose";
    private final static String ttfPath = "fonts/Terminus.ttf";
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f;
    private final static String PLAY = "Tap to play";//TODO добавить мигание надписи
    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;
    private final static float scaleXY = ((scaleX + scaleY) / 2f);
    private final static String PATH_TO_FIRST = "levels/1/2";
    private final static String PATH_TO_SECOND = "levels/2/1";
    private final static String PATH_TO_THIRD = "levels/3/2";
    private final static String PATH_TO_FOURTH = "levels/4/1";
    private static final float LOSE_TO_SCREEN = 7.5f;
    private static final int WIDTH = Gdx.app.getGraphics().getWidth();
    private static final int HEIGHT = Gdx.app.getGraphics().getHeight();
    private static int countOfAllPoints = 0;
    Consts() {


    }

    public static String getPathToFourth() {
        return PATH_TO_FOURTH;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static float getLOSE_TO_SCREEN() {
        return LOSE_TO_SCREEN;
    }

    public static String getPathToThird() {
        return PATH_TO_THIRD;
    }

    public static String getPathToSecond() {
        return PATH_TO_SECOND;
    }

    public static int getCountOfAllPoints() {
        return countOfAllPoints;
    }

    public static void setCountOfAllPoints(int countOfAllPoints) {
        Consts.countOfAllPoints = countOfAllPoints;
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
