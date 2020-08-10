package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Consts {

    private final static String LOSE = "You lose";//константа текста победы
    private final static String WIN = "You WIN!";//константа текста проигрыша
    private final static String ttfPath = "fonts/Terminus.ttf";//путь к шрифту
    private final static String PLAY = "Tap to play";//TODO добавить мигание надписи //в игрее этого пока что вообще нет
    //
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f; //масштабируем под экран
    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;
    private final static float scaleXY = ((scaleX + scaleY) / 2f);
    private final static float LOSE_TO_SCREEN = 7.5f; //константа для подгона кегля под экран, вроде
    //
    private final static String PATH_TO_FIRST = "levels/1/2";//пути к файлам базовых уровней
    private final static String PATH_TO_SECOND = "levels/2/1";
    private final static String PATH_TO_THIRD = "levels/3/2";
    private final static String PATH_TO_FOURTH = "levels/4/1";
    //
    private final static String PATH_TO_FIRST_ROTATION = "levels/1/1_2/1";//пути к файлам крутящихся уровней
    private final static String PATH_TO_SECOND_ROTATION = "levels/2/2_2/1";
    private final static String PATH_TO_THIRD_ROTATION = "levels/3/3_2/1";
    private final static String PATH_TO_FOURTH_ROTATION = "levels/4/4_2/1";
    //
    private final static int WIDTH = Gdx.app.getGraphics().getWidth();//ширина и высота экрана
    private final static int HEIGHT = Gdx.app.getGraphics().getHeight();
    //
    private final static String COUNT1 = "countOfPoints1";//стринги-ключи к preferences
    private final static String COUNT2 = "countOfPoints2";
    private final static String COUNT3 = "countOfPoints3";
    private final static String COUNT4 = "countOfPoints4";
    //
    private final static String COUNT11 = "countOfPoints11";
    private final static String COUNT21 = "countOfPoints21";
    private final static String COUNT31 = "countOfPoints31";
    private final static String COUNT41 = "countOfPoints41";
    //
    private final static String COUNT12 = "countOfPoints12";
    private final static String COUNT22 = "countOfPoints22";
    private final static String COUNT32 = "countOfPoints32";
    private final static String COUNT42 = "countOfPoints42";
    //
    private final static String COUNT1R = "countOfPoints1R";
    private final static String COUNT2R = "countOfPoints2R";
    private final static String COUNT3R = "countOfPoints3R";
    private final static String COUNT4R = "countOfPoints4R";
    private final static String COUNT0 = "countOfAllPoints";
    //
    private final static String PREF_NAME = "data";//имя файла preferences
    //
    private static int countOfAllPoints;//константа sum of best
    //
    private static int countOfPoints1;//константы счёта по уровням
    private static int countOfPoints2;
    private static int countOfPoints3;
    private static int countOfPoints4;
    //
    private static int countOfPoints11;
    private static int countOfPoints21;
    private static int countOfPoints31;
    private static int countOfPoints41;
    //
    private static int countOfPoints12;
    private static int countOfPoints22;
    private static int countOfPoints32;
    private static int countOfPoints42;
    //
    private static int countOfPoints1R;
    private static int countOfPoints2R;
    private static int countOfPoints3R;
    private static int countOfPoints4R;

    Consts() {


    }

    public static String getCOUNT12() {
        return COUNT12;
    }

    public static String getCOUNT22() {
        return COUNT22;
    }

    public static String getCOUNT32() {
        return COUNT32;
    }

    public static String getCOUNT42() {
        return COUNT42;
    }

    public static int getCountOfPoints12() {
        return countOfPoints12;
    }

    public static void setCountOfPoints12(int countOfPoints12) {
        Consts.countOfPoints12 = countOfPoints12;
    }

    public static int getCountOfPoints22() {
        return countOfPoints22;
    }

    public static void setCountOfPoints22(int countOfPoints22) {
        Consts.countOfPoints22 = countOfPoints22;
    }

    public static int getCountOfPoints32() {
        return countOfPoints32;
    }

    public static void setCountOfPoints32(int countOfPoints32) {
        Consts.countOfPoints32 = countOfPoints32;
    }

    public static int getCountOfPoints42() {
        return countOfPoints42;
    }

    public static void setCountOfPoints42(int countOfPoints42) {
        Consts.countOfPoints42 = countOfPoints42;
    }

    public static String getCOUNT11() {
        return COUNT11;
    }

    public static String getCOUNT21() {
        return COUNT21;
    }

    public static String getCOUNT31() {
        return COUNT31;
    }

    public static String getCOUNT41() {
        return COUNT41;
    }

    public static int getCountOfPoints11() {
        return countOfPoints11;
    }

    public static void setCountOfPoints11(int countOfPoints11) {
        Consts.countOfPoints11 = countOfPoints11;
    }

    public static int getCountOfPoints21() {
        return countOfPoints21;
    }

    public static void setCountOfPoints21(int countOfPoints21) {
        Consts.countOfPoints21 = countOfPoints21;
    }

    public static int getCountOfPoints31() {
        return countOfPoints31;
    }

    public static void setCountOfPoints31(int countOfPoints31) {
        Consts.countOfPoints31 = countOfPoints31;
    }

    public static int getCountOfPoints41() {
        return countOfPoints41;
    }

    public static void setCountOfPoints41(int countOfPoints41) {
        Consts.countOfPoints41 = countOfPoints41;
    }

    public static void clear() {

        Gdx.gl.glClearColor(242, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static String getCOUNT1R() {
        return COUNT1R;
    }

    public static String getCOUNT2R() {
        return COUNT2R;
    }

    public static String getCOUNT3R() {
        return COUNT3R;
    }

    public static String getCOUNT4R() {
        return COUNT4R;
    }

    public static int getCountOfPoints1R() {
        return countOfPoints1R;
    }

    public static void setCountOfPoints1R(int countOfPoints1R) {
        Consts.countOfPoints1R = countOfPoints1R;
    }

    public static int getCountOfPoints2R() {
        return countOfPoints2R;
    }

    public static void setCountOfPoints2R(int countOfPoints2R) {
        Consts.countOfPoints2R = countOfPoints2R;
    }

    public static int getCountOfPoints3R() {
        return countOfPoints3R;
    }

    public static void setCountOfPoints3R(int countOfPoints3R) {
        Consts.countOfPoints3R = countOfPoints3R;
    }

    public static int getCountOfPoints4R() {
        return countOfPoints4R;
    }

    public static void setCountOfPoints4R(int countOfPoints4R) {
        Consts.countOfPoints4R = countOfPoints4R;
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
