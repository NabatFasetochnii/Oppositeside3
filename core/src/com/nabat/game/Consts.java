package com.nabat.game;

import com.badlogic.gdx.Gdx;

public class Consts {

    private final static String LOSE = "You lose";
    private final static String WIN = "You WIN!";
    private final static String ttfPath = "fonts/Terminus.ttf";
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f;
    private final static String PLAY = "Tap to play";//TODO добавить мигание надписи
    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;
    private final static float scaleXY = ((scaleX + scaleY) / 2f);
    private final static String PATH_TO_FIRST = "levels/1/2";
    private final static String PATH_TO_FIRST_ROTATION = "levels/1/1_2/1";
    private final static String PATH_TO_SECOND = "levels/2/1";
    private final static String PATH_TO_SECOND_ROTATION = "levels/2/2_2/1";
    private final static String PATH_TO_THIRD = "levels/3/2";
    private final static String PATH_TO_THIRD_ROTATION = "levels/3/3_2/1";
    private final static String PATH_TO_FOURTH = "levels/4/1";
    private final static String PATH_TO_FOURTH_ROTATION = "levels/4/4_2/1";
    private final static float LOSE_TO_SCREEN = 7.5f;
    private final static int WIDTH = Gdx.app.getGraphics().getWidth();
    private final static int HEIGHT = Gdx.app.getGraphics().getHeight();
    private final static String COUNT1 = "countOfPoints1";
    private final static String COUNT2 = "countOfPoints2";
    private final static String COUNT3 = "countOfPoints3";
    private final static String COUNT4 = "countOfPoints4";
    private final static String COUNT0 = "countOfAllPoints";
    private final static String PREF_NAME = "data";
    private static int countOfAllPoints;
    private static int countOfPoints1;
    private static int countOfPoints2;
    private static int countOfPoints3;
    private static int countOfPoints4;
    Consts() {


    }

    public static String getPathToSecondRotation() {
        return PATH_TO_SECOND_ROTATION;
    }

    public static String getPathToThirdRotation() {
        return PATH_TO_THIRD_ROTATION;
    }

    public static String getPathToFourthRotation() {
        return PATH_TO_FOURTH_ROTATION;
    }

    public static String getPathToFirstRotation() {
        return PATH_TO_FIRST_ROTATION;
    }

    public static String getWIN() {
        return WIN;
    }

    public static String getCOUNT1() {
        return COUNT1;
    }

    public static String getCOUNT2() {
        return COUNT2;
    }

    public static String getCOUNT3() {
        return COUNT3;
    }

    public static String getCOUNT4() {
        return COUNT4;
    }

    public static String getCOUNT0() {
        return COUNT0;
    }

    public static String getPrefName() {
        return PREF_NAME;
    }

    public static int getCountOfPoints1() {
        return countOfPoints1;
    }

    public static void setCountOfPoints1(int countOfPoints1) {
        Consts.countOfPoints1 = countOfPoints1;
    }

    public static int getCountOfPoints2() {
        return countOfPoints2;
    }

    public static void setCountOfPoints2(int countOfPoints2) {
        Consts.countOfPoints2 = countOfPoints2;
    }

    public static int getCountOfPoints3() {
        return countOfPoints3;
    }

    public static void setCountOfPoints3(int countOfPoints3) {
        Consts.countOfPoints3 = countOfPoints3;
    }

    public static int getCountOfPoints4() {
        return countOfPoints4;
    }

    public static void setCountOfPoints4(int countOfPoints4) {
        Consts.countOfPoints4 = countOfPoints4;
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
