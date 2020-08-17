package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Consts {

    private final static String LOSE = "You lose";//константа текста победы
    private final static String WIN = "You WIN!";//константа текста проигрыша
    private final static String ttfPath = "fonts/Terminus.ttf";//путь к шрифту
    private final static String PLAY = "Tap to play";//TODO добавить мигание надписи //в игрее этого пока что вообще нет
    //
    //private final static String SOUND = "Sound";
    private final static String GPGS = "Google Play\nGames: ";
    private final static String OFF = "OFF";
    private final static String ON = "ON";
    //
    private final static float scaleX = Gdx.app.getGraphics().getWidth() / 1080f; //масштабируем под экран
    private final static float scaleY = Gdx.app.getGraphics().getHeight() / 1920f;
    private final static float scaleXY = ((scaleX + scaleY) / 2f);
    private final static float LOSE_TO_SCREEN = 7.5f; //константа для подгона кегля под экран, вроде
    //
    private final static String PATH_TO_FIRST = "levels/1/1";//пути к файлам базовых уровней
    private final static String PATH_TO_SECOND = "levels/2/1";
    private final static String PATH_TO_THIRD = "levels/3/1";
    private final static String PATH_TO_FOURTH = "levels/4/1";
    //
    private final static String PATH_TO_FIRST_COMPLICATED = "levels/1/2";
    private final static String PATH_TO_SECOND_COMPLICATED = "levels/2/2";
    private final static String PATH_TO_THIRD_COMPLICATED = "levels/3/2";
    private final static String PATH_TO_FOURTH_COMPLICATED = "levels/4/2";
    //
    private final static String PATH_TO_FIRST_ROTATION = "levels/1/1_2/1";//пути к файлам крутящихся уровней
    private final static String PATH_TO_SECOND_ROTATION = "levels/2/2_2/1";
    private final static String PATH_TO_THIRD_ROTATION = "levels/3/3_2/1";
    private final static String PATH_TO_FOURTH_ROTATION = "levels/4/4_2/1";
    //
    private final static String PATH_TO_FIRST_ROTATION_COMPLICATED = "levels/1/1_2/2";//пути к файлам крутящихся уровней
    private final static String PATH_TO_SECOND_ROTATION_COMPLICATED = "levels/2/2_2/2";
    private final static String PATH_TO_THIRD_ROTATION_COMPLICATED = "levels/3/3_2/2";
    private final static String PATH_TO_FOURTH_ROTATION_COMPLICATED = "levels/4/4_2/2";
    //
    private final static String PATH_TO_MUSIC = "audio/music.mp3";
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
    private final static String COUNT111 = "countOfPoints111";
    private final static String COUNT211 = "countOfPoints211";
    private final static String COUNT311 = "countOfPoints311";
    private final static String COUNT411 = "countOfPoints411";
    //
    private final static String COUNT12 = "countOfPoints12";
    private final static String COUNT22 = "countOfPoints22";
    private final static String COUNT32 = "countOfPoints32";
    private final static String COUNT42 = "countOfPoints42";
    //
    private final static String COUNT121 = "countOfPoints121";
    private final static String COUNT221 = "countOfPoints221";
    private final static String COUNT321 = "countOfPoints321";
    private final static String COUNT421 = "countOfPoints421";
    //
    private final static String COUNT122 = "countOfPoints122";
    private final static String COUNT222 = "countOfPoints222";
    private final static String COUNT322 = "countOfPoints322";
    private final static String COUNT422 = "countOfPoints422";
    //
    private final static String COUNT1R = "countOfPoints1R";
    private final static String COUNT2R = "countOfPoints2R";
    private final static String COUNT3R = "countOfPoints3R";
    private final static String COUNT4R = "countOfPoints4R";
    //
    private final static String COUNT1R1 = "countOfPoints1R1";
    private final static String COUNT2R1 = "countOfPoints2R1";
    private final static String COUNT3R1 = "countOfPoints3R1";
    private final static String COUNT4R1 = "countOfPoints4R1";
    //
    private final static String COUNT1R2 = "countOfPoints1R2";
    private final static String COUNT2R2 = "countOfPoints2R2";
    private final static String COUNT3R2 = "countOfPoints3R2";
    private final static String COUNT4R2 = "countOfPoints4R2";
    //
    private final static String COUNT0 = "countOfAllPoints";
    //
    private final static String PREF_NAME = "data";//имя файла preferences
    //
    private final static String SOUND = "sound";
    //
    private static boolean sound;
    //
    private static boolean login;
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
    private static int countOfPoints111;
    private static int countOfPoints211;
    private static int countOfPoints311;
    private static int countOfPoints411;
    //
    private static int countOfPoints12;
    private static int countOfPoints22;
    private static int countOfPoints32;
    private static int countOfPoints42;
    //
    private static int countOfPoints121;
    private static int countOfPoints221;
    private static int countOfPoints321;
    private static int countOfPoints421;
    //
    private static int countOfPoints122;
    private static int countOfPoints222;
    private static int countOfPoints322;
    private static int countOfPoints422;
    //
    private static int countOfPoints1R;
    private static int countOfPoints2R;
    private static int countOfPoints3R;
    private static int countOfPoints4R;
    //
    private static int countOfPoints1R1;
    private static int countOfPoints2R1;
    private static int countOfPoints3R1;
    private static int countOfPoints4R1;
    //
    private static int countOfPoints1R2;
    private static int countOfPoints2R2;
    private static int countOfPoints3R2;
    private static int countOfPoints4R2;
    //
    private static BitmapFont fontForLose;
    private static BitmapFont fontForCount;
    private static BitmapFont fontForCountMiss;
    private static BitmapFont fontForWin;
    private static BitmapFont fontForMenu;
    Consts() {


    }

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        Consts.login = login;
    }

    public static boolean isTouch(TextureRegion textureRegion, int X, int Y) {

        return ((textureRegion.getU2() <= X) && (X <= textureRegion.getU())
                && (textureRegion.getV2() <= Y) && (Y <= textureRegion.getV()));
    }

    public static String getSOUND() {
        return SOUND;
    }

    public static boolean isSound() {
        return sound;
    }

    public static void setSound(boolean sound) {
        Consts.sound = sound;
    }

    public static String getGPGS() {
        return GPGS;
    }

    public static String getOFF() {
        return OFF;
    }

    public static String getON() {
        return ON;
    }

    public static BitmapFont getFontForMenu() {
        return fontForMenu;
    }

    public static String getPathToMusic() {
        return PATH_TO_MUSIC;
    }

    public static BitmapFont getFontForLose() {
        return fontForLose;
    }

    public static BitmapFont getFontForCount() {
        return fontForCount;
    }

    public static BitmapFont getFontForCountMiss() {
        return fontForCountMiss;
    }

    public static BitmapFont getFontForWin() {
        return fontForWin;
    }

    public static String getCOUNT1R1() {
        return COUNT1R1;
    }

    public static String getCOUNT2R1() {
        return COUNT2R1;
    }

    public static String getCOUNT3R1() {
        return COUNT3R1;
    }

    public static String getCOUNT4R1() {
        return COUNT4R1;
    }

    public static String getCOUNT1R2() {
        return COUNT1R2;
    }

    public static String getCOUNT2R2() {
        return COUNT2R2;
    }

    public static String getCOUNT3R2() {
        return COUNT3R2;
    }

    public static String getCOUNT4R2() {
        return COUNT4R2;
    }

    public static int getCountOfPoints1R1() {
        return countOfPoints1R1;
    }

    public static void setCountOfPoints1R1(int countOfPoints1R1) {
        Consts.countOfPoints1R1 = countOfPoints1R1;
    }

    public static int getCountOfPoints2R1() {
        return countOfPoints2R1;
    }

    public static void setCountOfPoints2R1(int countOfPoints2R1) {
        Consts.countOfPoints2R1 = countOfPoints2R1;
    }

    public static int getCountOfPoints3R1() {
        return countOfPoints3R1;
    }

    public static void setCountOfPoints3R1(int countOfPoints3R1) {
        Consts.countOfPoints3R1 = countOfPoints3R1;
    }

    public static int getCountOfPoints4R1() {
        return countOfPoints4R1;
    }

    public static void setCountOfPoints4R1(int countOfPoints4R1) {
        Consts.countOfPoints4R1 = countOfPoints4R1;
    }

    public static int getCountOfPoints1R2() {
        return countOfPoints1R2;
    }

    public static void setCountOfPoints1R2(int countOfPoints1R2) {
        Consts.countOfPoints1R2 = countOfPoints1R2;
    }

    public static int getCountOfPoints2R2() {
        return countOfPoints2R2;
    }

    public static void setCountOfPoints2R2(int countOfPoints2R2) {
        Consts.countOfPoints2R2 = countOfPoints2R2;
    }

    public static int getCountOfPoints3R2() {
        return countOfPoints3R2;
    }

    public static void setCountOfPoints3R2(int countOfPoints3R2) {
        Consts.countOfPoints3R2 = countOfPoints3R2;
    }

    public static int getCountOfPoints4R2() {
        return countOfPoints4R2;
    }

    public static void setCountOfPoints4R2(int countOfPoints4R2) {
        Consts.countOfPoints4R2 = countOfPoints4R2;
    }

    public static String getPathToFirstComplicated() {
        return PATH_TO_FIRST_COMPLICATED;
    }

    public static String getPathToSecondComplicated() {
        return PATH_TO_SECOND_COMPLICATED;
    }

    public static String getPathToThirdComplicated() {
        return PATH_TO_THIRD_COMPLICATED;
    }

    public static String getPathToFourthComplicated() {
        return PATH_TO_FOURTH_COMPLICATED;
    }

    public static String getPathToFirstRotationComplicated() {
        return PATH_TO_FIRST_ROTATION_COMPLICATED;
    }

    public static String getPathToSecondRotationComplicated() {
        return PATH_TO_SECOND_ROTATION_COMPLICATED;
    }

    public static String getPathToThirdRotationComplicated() {
        return PATH_TO_THIRD_ROTATION_COMPLICATED;
    }

    public static String getPathToFourthRotationComplicated() {
        return PATH_TO_FOURTH_ROTATION_COMPLICATED;
    }

    public static int getCountOfPoints111() {
        return countOfPoints111;
    }

    public static void setCountOfPoints111(int countOfPoints111) {
        Consts.countOfPoints111 = countOfPoints111;
    }

    public static int getCountOfPoints211() {
        return countOfPoints211;
    }

    public static void setCountOfPoints211(int countOfPoints211) {
        Consts.countOfPoints211 = countOfPoints211;
    }

    public static int getCountOfPoints311() {
        return countOfPoints311;
    }

    public static void setCountOfPoints311(int countOfPoints311) {
        Consts.countOfPoints311 = countOfPoints311;
    }

    public static int getCountOfPoints411() {
        return countOfPoints411;
    }

    public static void setCountOfPoints411(int countOfPoints411) {
        Consts.countOfPoints411 = countOfPoints411;
    }

    public static int getCountOfPoints121() {
        return countOfPoints121;
    }

    public static void setCountOfPoints121(int countOfPoints121) {
        Consts.countOfPoints121 = countOfPoints121;
    }

    public static int getCountOfPoints221() {
        return countOfPoints221;
    }

    public static void setCountOfPoints221(int countOfPoints221) {
        Consts.countOfPoints221 = countOfPoints221;
    }

    public static int getCountOfPoints321() {
        return countOfPoints321;
    }

    public static void setCountOfPoints321(int countOfPoints321) {
        Consts.countOfPoints321 = countOfPoints321;
    }

    public static int getCountOfPoints421() {
        return countOfPoints421;
    }

    public static void setCountOfPoints421(int countOfPoints421) {
        Consts.countOfPoints421 = countOfPoints421;
    }

    public static int getCountOfPoints122() {
        return countOfPoints122;
    }

    public static void setCountOfPoints122(int countOfPoints122) {
        Consts.countOfPoints122 = countOfPoints122;
    }

    public static int getCountOfPoints222() {
        return countOfPoints222;
    }

    public static void setCountOfPoints222(int countOfPoints222) {
        Consts.countOfPoints222 = countOfPoints222;
    }

    public static int getCountOfPoints322() {
        return countOfPoints322;
    }

    public static void setCountOfPoints322(int countOfPoints322) {
        Consts.countOfPoints322 = countOfPoints322;
    }

    public static int getCountOfPoints422() {
        return countOfPoints422;
    }

    public static void setCountOfPoints422(int countOfPoints422) {
        Consts.countOfPoints422 = countOfPoints422;
    }

    public static String getCOUNT111() {
        return COUNT111;
    }

    public static String getCOUNT211() {
        return COUNT211;
    }

    public static String getCOUNT311() {
        return COUNT311;
    }

    public static String getCOUNT411() {
        return COUNT411;
    }

    public static String getCOUNT121() {
        return COUNT121;
    }

    public static String getCOUNT221() {
        return COUNT221;
    }

    public static String getCOUNT321() {
        return COUNT321;
    }

    public static String getCOUNT421() {
        return COUNT421;
    }

    public static String getCOUNT122() {
        return COUNT122;
    }

    public static String getCOUNT222() {
        return COUNT222;
    }

    public static String getCOUNT322() {
        return COUNT322;
    }

    public static String getCOUNT422() {
        return COUNT422;
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

    public static void loadFonts() {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (WIDTH / LOSE_TO_SCREEN);
        parameter.color = Color.RED;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        fontForLose = generator.generateFont(parameter);

        parameter.color = Color.GREEN;

        fontForWin = generator.generateFont(parameter);

        parameter.size = (int) (WIDTH / 10f);
        parameter.borderWidth = 3;
        fontForCount = generator.generateFont(parameter);

        parameter.color = Color.RED;

        fontForCountMiss = generator.generateFont(parameter);

        parameter.size = Gdx.app.getGraphics().getWidth() / 12;
        parameter.color = Color.CHARTREUSE;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        fontForMenu = generator.generateFont(parameter);

        generator.dispose();
    }

    public static void clear() {

        Gdx.gl.glClearColor(240, 240, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static void dispose() {
        fontForCount.dispose();
        fontForCountMiss.dispose();
        fontForLose.dispose();
        fontForWin.dispose();
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
