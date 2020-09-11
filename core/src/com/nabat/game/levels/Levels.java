package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForMenu;

import java.util.ArrayList;
import java.util.Map;

public class Levels implements Screen {
    //    private static int lvl = 0;
    private final RectZone l1, l2, l3, l4; //квадраты на экране, символизирующие кнопки уровней //первая цифра - колво квадратов,  вторая - режим, третья - счётчик
    private final RectZone l11, l21, l31, l41;
    private final RectZone l111, l211, l311, l411; //уровни меньшей площади
    private final RectZone l12, l22, l32, l42;
    private final RectZone l121, l221, l321, l421;
    private final RectZone l122, l222, l322, l422;
    private final RectZone l1R, l2R, l3R, l4R;
    private final RectZone l1R1, l2R1, l3R1, l4R1;
    private final RectZone l1R2, l2R2, l3R2, l4R2;
    private final RectZone l13, l23, l33, l43;
    private final RectZone l131, l231, l331, l431;
    private final RectZone l132, l232, l332, l432;
    private final MyGame myGame;
    private final ArrayList<RectZone> zoneList;
    private final int zeroPoint;
    private final int endPoint;
    private final Color color1, color2, color3, color4;
    private final int rectsS;
    private final float sumOfBestX;
    private final float sumOfBestY;
    private final float scoreW;
    private final String section1 = "Normal";
    private final String section2 = "Reduction";
    private final String section3 = "Rotation";
    private final String section4 = "Disappear";
    private final float section1_y;
    private int scrollX = 0;
    private String score;
    private float section1_x;
    private float section2_x;
    private float section3_x;
    private float section4_x;

    public Levels(MyGame myGame) {
        zoneList = new ArrayList<>();
        this.myGame = myGame;

        sumOfBestX = Consts.getWIDTH() / 22f;
        sumOfBestY = Consts.getHEIGHT() - sumOfBestX;

        color1 = Color.RED;
        color2 = parseColor("#714cfe");//
        color3 = Color.LIME;
        color4 = parseColor("#fa8100");//

        Color color01 = parseColor("#3dee02");
        Color color02 = parseColor("#1edc00");
        Color color03 = parseColor("#00c700");

        Color color11 = parseColor("#319efe");
        Color color12 = parseColor("#0280ee");
        Color color13 = parseColor("#0b6eda");

        Color color21 = parseColor("#ff593a");//#ff2410
        Color color22 = parseColor("#ff2410");
        Color color23 = parseColor("#ee0202");

        Color color31 = parseColor("#ec58f2");
        Color color32 = parseColor("#e602ee");
        Color color33 = parseColor("#cc00e5");

        GlyphLayout glyphLayout = new GlyphLayout(myGame.loader.getFontForMenu(),
                "Sum of best: " + Consts.getMap().get(Consts.getCOUNT0()));

        scoreW = glyphLayout.width;
        float scoreH = glyphLayout.height;

        zeroPoint = Consts.getWIDTH() / 10;
        rectsS = Consts.getWIDTH() / 10;
        section1_y = sumOfBestY - scoreH * 2;

        int rectsY = (int) (section1_y - scoreH * 2.5f - rectsS);
        int rectsX = Consts.getWIDTH() / 10;

        int rectDelta = Consts.getWIDTH() / 5;

        if (scoreW > Consts.getWIDTH() - sumOfBestX * 2 - rectsS) {
            score = "Sum of best:\n" + Consts.getMap().get(Consts.getCOUNT0());
        } else {
            score = "Sum of best: " + Consts.getMap().get(Consts.getCOUNT0());
        }

        l1 = new RectZone(rectsX, rectsY, rectsS, rectsS, color01);
        l2 = new RectZone(rectsX, rectsY - rectDelta, rectsS, rectsS, color01);
        l3 = new RectZone(rectsX, rectsY - 2 * rectDelta, rectsS, rectsS, color01);
        l4 = new RectZone(rectsX, rectsY - 3 * rectDelta, rectsS, rectsS, color01);

        ////////////////////////////////

        int c = 1;

        l11 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color02);
        l21 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color02);
        l31 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color02);
        l41 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color02);

        ////////////////////////////////
        c = 2;

        l111 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color03);
        l211 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color03);
        l311 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color03);
        l411 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color03);

        ////////////////////////////////
        c = 3;
        l12 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color11);
        l22 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color11);
        l32 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color11);
        l42 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color11);

        ////////////////////////////////
        c = 4;

        l121 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color12);
        l221 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color12);
        l321 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color12);
        l421 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color12);

        /////////////////////////////////////////////////

        c = 5;

        l122 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color13);
        l222 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color13);
        l322 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color13);
        l422 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color13);

        /////////////////////////////////////////////////
        c = 6;

        l1R = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color21);//new Color(116,73,255,100)
        l2R = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color21);
        l3R = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color21);
        l4R = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color21);

        /////////////////////////////////////////////////
        c = 7;

        l1R1 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color22);//new Color(116,73,255,100)
        l2R1 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color22);
        l3R1 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color22);
        l4R1 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color22);

        /////////////////////////////////////////////////
        c = 8;

        l1R2 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color23);//new Color(116,73,255,100)
        l2R2 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color23);
        l3R2 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color23);
        l4R2 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color23);

        /////////////////////////////////////////////////
        c = 9;

        l13 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color31);//new Color(116,73,255,100)
        l23 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color31);
        l33 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color31);
        l43 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color31);

        /////////////////////////////////////////////////
        c = 10;

        l131 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color32);//new Color(116,73,255,100)
        l231 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color32);
        l331 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color32);
        l431 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color32);

        /////////////////////////////////////////////////
        c = 11;

        l132 = new RectZone(rectsX + c * rectDelta, rectsY, rectsS, rectsS, color33);//new Color(116,73,255,100)
        l232 = new RectZone(rectsX + c * rectDelta, rectsY - rectDelta, rectsS, rectsS, color33);
        l332 = new RectZone(rectsX + c * rectDelta, rectsY - 2 * rectDelta, rectsS, rectsS, color33);
        l432 = new RectZone(rectsX + c * rectDelta, rectsY - 3 * rectDelta, rectsS, rectsS, color33);

        endPoint = Consts.getWIDTH() - zeroPoint - l1.getWidth();

        glyphLayout = new GlyphLayout(myGame.loader.getFontForMenu(), section1);
        section1_x = l11.getX() + l11.getWidth() / 2f - glyphLayout.width / 2f;

        glyphLayout = new GlyphLayout(myGame.loader.getFontForMenu(), section2);
        section2_x = l121.getX() + l121.getWidth() / 2f - glyphLayout.width / 2f;

        glyphLayout = new GlyphLayout(myGame.loader.getFontForMenu(), section3);
        section3_x = l1R1.getX() + l1R1.getWidth() / 2f - glyphLayout.width / 2f;

        glyphLayout = new GlyphLayout(myGame.loader.getFontForMenu(), section4);
        section4_x = l131.getX() + l131.getWidth() / 2f - glyphLayout.width / 2f;

        zoneList.add(l1);
        zoneList.add(l2);
        zoneList.add(l3);
        zoneList.add(l4);

        zoneList.add(l11);
        zoneList.add(l21);
        zoneList.add(l31);
        zoneList.add(l41);

        zoneList.add(l111);
        zoneList.add(l211);
        zoneList.add(l311);
        zoneList.add(l411);

        zoneList.add(l12);
        zoneList.add(l22);
        zoneList.add(l32);
        zoneList.add(l42);

        zoneList.add(l121);
        zoneList.add(l221);
        zoneList.add(l321);
        zoneList.add(l421);

        zoneList.add(l122);
        zoneList.add(l222);
        zoneList.add(l322);
        zoneList.add(l422);

        zoneList.add(l1R);
        zoneList.add(l2R);
        zoneList.add(l3R);
        zoneList.add(l4R);

        zoneList.add(l1R1);
        zoneList.add(l2R1);
        zoneList.add(l3R1);
        zoneList.add(l4R1);

        zoneList.add(l1R2);
        zoneList.add(l2R2);
        zoneList.add(l3R2);
        zoneList.add(l4R2);

        zoneList.add(l13);
        zoneList.add(l23);
        zoneList.add(l33);
        zoneList.add(l43);

        zoneList.add(l131);
        zoneList.add(l231);
        zoneList.add(l331);
        zoneList.add(l431);

        zoneList.add(l132);
        zoneList.add(l232);
        zoneList.add(l332);
        zoneList.add(l432);
    }

    //TODO ДОБАВИТЬ МЕХАНИКУ ПЕРЕСТАНОВКИ КВАДРАТИКОВ,
    // МБ НАЛОЖЕНИЕ ОДНОГО НА ДРУГОГО ИЛИ ДОПОЛНЕНИЕ (НАПРИМЕР СОПОСТАВИТЬ КВАДРАТ И ЕГО РАМКУ)

    public void setStart() {
        myGame.setScreen(new Start(myGame));
    }

    public void setLvl(int lvl) {
//        Levels.lvl = lvl;

        switch (lvl) {
            case 1: { /////базовый набор уровней
                LevelFactory lvl_f = new LevelFactory(color1,
                        20, Consts.getPathToFirst(), 100, 1, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 2: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        30, Consts.getPathToSecond(), 100, 2, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 3: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        30, Consts.getPathToThird(), 50, 3, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 4: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        50, Consts.getPathToFourth(), 50, 4, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 11: { //продвинутый набор уровней
                LevelFactory lvl_f = new LevelFactory(color1,
                        35, Consts.getPathToFirst(), 200, 1, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 21: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        35, Consts.getPathToSecond(), 200, 2, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 31: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        50, Consts.getPathToThird(), 200, 3, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;
            }
            case 41: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        60, Consts.getPathToFourth(), 200, 4, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//1850+800=2650
            }
            ////////////////////////////////////////
            case 111: { //продвинутый набор уровней
                LevelFactory lvl_f = new LevelFactory(color1,
                        35, Consts.getPathToFirstComplicated(), 200, 1, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//2850
            }
            case 211: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        35, Consts.getPathToSecondComplicated(), 200, 2, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//3250
            }
            case 311: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        50, Consts.getPathToThirdComplicated(), 200, 3, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//3850
            }
            case 411: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        60, Consts.getPathToFourthComplicated(), 200, 4, myGame, lvl);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//4650
            }
            ////////////////////////////////////////
            case 12: {

                LevelFactory lvl_f = new LevelFactory(color1,
                        20, Consts.getPathToFirst(), 100, 1, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//4750
            }
            case 22: {

                LevelFactory lvl_f = new LevelFactory(color2,
                        30, Consts.getPathToSecond(), 100, 2, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//4950
                break;
            }
            case 32: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        35, Consts.getPathToThird(), 50, 3, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5100
                break;
            }
            case 42: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        50, Consts.getPathToFourth(), 50, 4, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5300
                break;
            }
            ////////////////////////////////////////
            case 121: {
                LevelFactory lvl_f = new LevelFactory(color1,
                        35, Consts.getPathToFirst(), 400, 1, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5700
                break;
            }
            case 221: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        40, Consts.getPathToSecond(), 300, 2, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//6300
                break;
            }
            case 321: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        40, Consts.getPathToThird(), 150, 3, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//6750
            }
            case 421: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        40, Consts.getPathToFourth(), 100, 4, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//7150
            }
            ////////////////////////////////////////
            case 122: {
                LevelFactory lvl_f = new LevelFactory(color1,
                        40, Consts.getPathToFirstComplicated(), 400, 1, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//7550
            }
            case 222: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        40, Consts.getPathToSecondComplicated(), 300, 2, myGame, lvl);
                lvl_f.setDot(true);

                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//8150
            }
            case 322: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        40, Consts.getPathToThirdComplicated(), 150, 3, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//8600
            }
            case 422: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        40, Consts.getPathToFourthComplicated(), 100, 4, myGame, lvl);
                lvl_f.setDot(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//9000
            }
            ////////////////////////////////////////
            case 10: { //набор уровней с кручением

                LevelFactory lvl_f = new LevelFactory(color1,
                        40, Consts.getPathToFirstRotation(), 300, 1, myGame, lvl);
                lvl_f.setRotation(true, 5);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//9300
            }
            case 20: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        60, Consts.getPathToSecondRotation(), 100, 2, myGame, lvl);
                lvl_f.setRotation(true, 2);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//9500
            }

            case 30: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        60, Consts.getPathToThirdRotation(), 100, 3, myGame, lvl);
                lvl_f.setRotation(true, 1);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//9800
            }
            case 40: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        60, Consts.getPathToFourthRotation(), 50, 4, myGame, lvl);
                lvl_f.setRotation(true, 0.5f);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//10_000
            }
            ////////////////////////////////////////
            case 101: { //набор уровней с кручением

                LevelFactory lvl_f = new LevelFactory(color4,
                        80, Consts.getPathToFirstRotation(), 500, 1, myGame, lvl);
                lvl_f.setRotation(true, 4);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//10500
            }
            case 201: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        80, Consts.getPathToSecondRotation(), 200, 2, myGame, lvl);
                lvl_f.setRotation(true, 2);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//10900
            }

            case 301: {

                LevelFactory lvl_f = new LevelFactory(color3,
                        80, Consts.getPathToThirdRotation(), 150, 3, myGame, lvl);
                lvl_f.setRotation(true, 1);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//11350
            }
            case 401: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        80, Consts.getPathToFourthRotation(), 100, 4, myGame, lvl);
                lvl_f.setRotation(true, 0.5f);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//11750
            }
            ////////////////////////////////////////
            case 102: { //набор уровней с кручением

                // сами уровни
                LevelFactory lvl_f = new LevelFactory(color1,
                        100, Consts.getPathToFirstRotationComplicated(), 600, 1, myGame, lvl);
                lvl_f.setRotation(true, 3);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//12350
            }
            case 202: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        100, Consts.getPathToSecondRotationComplicated(), 300, 2, myGame, lvl);
                lvl_f.setRotation(true, 1);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//12950
            }

            case 302: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        100, Consts.getPathToThirdRotationComplicated(), 200, 3, myGame, lvl);
                lvl_f.setRotation(true, 0.5f);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//13550
            }
            case 402: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        100, Consts.getPathToFourthRotationComplicated(), 200, 4, myGame, lvl);
                lvl_f.setRotation(true, 0.25f);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//14350
            }
            ////////////////////////////////////////
            case 13: {

                LevelFactory lvl_f = new LevelFactory(color1,
                        20, Consts.getPathToFirst(), 100, 1, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//4750
            }
            case 23: {

                LevelFactory lvl_f = new LevelFactory(color2,
                        30, Consts.getPathToSecond(), 100, 2, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//4950
                break;
            }
            case 33: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        35, Consts.getPathToThird(), 50, 3, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5100
                break;
            }
            case 43: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        50, Consts.getPathToFourth(), 50, 4, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5300
                break;
            }
            ////////////////////////////////////////
            case 131: {
                LevelFactory lvl_f = new LevelFactory(color1,
                        35, Consts.getPathToFirst(), 400, 1, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//5700
                break;
            }
            case 231: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        40, Consts.getPathToSecond(), 300, 2, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;//6300
                break;
            }
            case 331: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        40, Consts.getPathToThird(), 150, 3, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//6750
            }
            case 431: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        40, Consts.getPathToFourth(), 100, 4, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//7150
            }
            ////////////////////////////////////////
            case 132: {
                LevelFactory lvl_f = new LevelFactory(color1,
                        40, Consts.getPathToFirstComplicated(), 400, 1, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//7550
            }
            case 232: {
                LevelFactory lvl_f = new LevelFactory(color2,
                        40, Consts.getPathToSecondComplicated(), 300, 2, myGame, lvl);
                lvl_f.setAlf(true);

                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//8150
            }
            case 332: {
                LevelFactory lvl_f = new LevelFactory(color3,
                        40, Consts.getPathToThirdComplicated(), 150, 3, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//8600
            }
            case 432: {
                LevelFactory lvl_f = new LevelFactory(color4,
                        40, Consts.getPathToFourthComplicated(), 100, 4, myGame, lvl);
                lvl_f.setAlf(true);
                myGame.setScreen(new InfoScreen(myGame, lvl_f));
//                lvl = 0;
                break;//9000
            }
        }
    }

    public int getRectsS() {
        return rectsS;
    }

    private void drawNumber(String s, RectZone r) {

        myGame.loader.getFontForMenu().draw(myGame.getBatch(), s, r.getX() + r.getWidth() / 3f, r.getY() + r.getHeight() / 1.3f);
    }

    @Override
    public void render(float delta) {

        Consts.clear();

        for (RectZone r : zoneList) {
            r.draw();
        }

        myGame.getBatch().begin();

        drawNumber("1", l1);
        drawNumber("2", l2);
        drawNumber("3", l3);
        drawNumber("4", l4);

        myGame.getBatch().draw(myGame.loader.getSettingsButton(),
                Consts.getWIDTH() - rectsS,
                Consts.getHEIGHT() - rectsS, rectsS, rectsS);

        myGame.loader.getFontForMenu().draw(myGame.getBatch(), score, sumOfBestX, sumOfBestY);
        myGame.loader.getFontForMenu().draw(myGame.getBatch(), section1, section1_x, section1_y);
        myGame.loader.getFontForMenu().draw(myGame.getBatch(), section2, section2_x, section1_y);
        myGame.loader.getFontForMenu().draw(myGame.getBatch(), section3, section3_x, section1_y);
        myGame.loader.getFontForMenu().draw(myGame.getBatch(), section4, section4_x, section1_y);

        for (Map.Entry<Integer, Boolean> integerEntry : Consts.getIsWin().entrySet()) {
            if (integerEntry.getValue()) {
                RectZone r = getZone(integerEntry.getKey());
                if (r != null) {
                    myGame.getBatch().draw(myGame.loader.getWinIcon(),
                            r.getX() + r.getWidth() * 2 / 3f, r.getY(),
                            r.getWidth() / 1.3f, r.getHeight() / 1.3f);//1.5f
                }
            }
        }

        myGame.getBatch().end();
    }

    @Override
    public void show() {

        if (scoreW > Consts.getWIDTH() - sumOfBestX * 2 - rectsS) {

            score = "Sum of best:\n" + Consts.getMap().get(Consts.getCOUNT0());
        } else {
            score = "Sum of best: " + Consts.getMap().get(Consts.getCOUNT0());

        }
        Gdx.input.setInputProcessor(new InputForMenu(this));
    }

    protected Color parseColor(String hex) {
        if (hex.length() == 7) {
            hex = hex.substring(1, 7);
        }
        String s1 = hex.substring(0, 2);//#ec58f2
        int v1 = Integer.parseInt(s1, 16);
        float f1 = 1f * v1 / 255f;
        String s2 = hex.substring(2, 4);
        int v2 = Integer.parseInt(s2, 16);
        float f2 = 1f * v2 / 255f;
        String s3 = hex.substring(4, 6);
        int v3 = Integer.parseInt(s3, 16);
        float f3 = 1f * v3 / 255f;
        return new Color(f1, f2, f3, 1f);
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

    public void dispose() {

        for (RectZone r : zoneList) {
            r.dispose();
        }
    }

    private RectZone getZone(int lvl) {
        switch (lvl) {

            case 1:
                return l1;
            case 2:
                return l2;
            case 3:
                return l3;
            case 4:
                return l4;

            case 11:
                return l11;
            case 21:
                return l21;
            case 31:
                return l31;
            case 41:
                return l41;

            case 111:
                return l111;
            case 211:
                return l211;
            case 311:
                return l311;
            case 411:
                return l411;
//
            case 12:
                return l12;
            case 22:
                return l22;
            case 32:
                return l32;
            case 42:
                return l42;

            case 121:
                return l121;
            case 221:
                return l221;
            case 321:
                return l321;
            case 421:
                return l421;

            case 122:
                return l122;
            case 222:
                return l222;
            case 322:
                return l322;
            case 422:
                return l422;
//
            case 10:
                return l1R;
            case 20:
                return l2R;
            case 30:
                return l3R;
            case 40:
                return l4R;

            case 101:
                return l1R1;
            case 201:
                return l2R1;
            case 301:
                return l3R1;
            case 401:
                return l4R1;

            case 102:
                return l1R2;
            case 202:
                return l2R2;
            case 302:
                return l3R2;
            case 402:
                return l4R2;
//
            case 13:
                return l13;
            case 23:
                return l23;
            case 33:
                return l33;
            case 43:
                return l43;

            case 131:
                return l131;
            case 231:
                return l231;
            case 331:
                return l331;
            case 431:
                return l431;

            case 132:
                return l132;
            case 232:
                return l232;
            case 332:
                return l332;
            case 432:
                return l432;

            default:
                return null;
        }
    }

    public int getScrollX() {
        return scrollX;
    }

    /////////scroll
    public void setScrollX(int scrollX) {

        if (l1.getX() - scrollX < zeroPoint && l132.getX() - scrollX > endPoint) {

            this.scrollX = scrollX;
            for (RectZone r : zoneList) {
                r.setX(r.getX() - scrollX);
            }
            section1_x -= scrollX;
            section2_x -= scrollX;
            section3_x -= scrollX;
            section4_x -= scrollX;
        }
    }

    public RectZone getL1R1() {
        return l1R1;
    }

    public RectZone getL2R1() {
        return l2R1;
    }

    public RectZone getL3R1() {
        return l3R1;
    }

    public RectZone getL4R1() {
        return l4R1;
    }

    public RectZone getL1R2() {
        return l1R2;
    }

    public RectZone getL2R2() {
        return l2R2;
    }

    public RectZone getL3R2() {
        return l3R2;
    }

    public RectZone getL4R2() {
        return l4R2;
    }

    public RectZone getL122() {
        return l122;
    }

    public RectZone getL222() {
        return l222;
    }

    public RectZone getL322() {
        return l322;
    }

    public RectZone getL422() {
        return l422;
    }

    public RectZone getL111() {
        return l111;
    }

    public RectZone getL211() {
        return l211;
    }

    public RectZone getL311() {
        return l311;
    }

    public RectZone getL411() {
        return l411;
    }

    public RectZone getL121() {
        return l121;
    }

    public RectZone getL221() {
        return l221;
    }

    public RectZone getL321() {
        return l321;
    }

    public RectZone getL421() {
        return l421;
    }

    public RectZone getL13() {
        return l13;
    }

    public RectZone getL23() {
        return l23;
    }

    public RectZone getL33() {
        return l33;
    }

    public RectZone getL43() {
        return l43;
    }

    public RectZone getL131() {
        return l131;
    }

    public RectZone getL231() {
        return l231;
    }

    public RectZone getL331() {
        return l331;
    }

    public RectZone getL431() {
        return l431;
    }

    public RectZone getL132() {
        return l132;
    }

    public RectZone getL232() {
        return l232;
    }

    public RectZone getL332() {
        return l332;
    }

    public RectZone getL12() {
        return l12;
    }

    public RectZone getL22() {
        return l22;
    }

    public RectZone getL32() {
        return l32;
    }

    public RectZone getL42() {
        return l42;
    }

    public RectZone getL11() {
        return l11;
    }

    public RectZone getL21() {
        return l21;
    }

    public RectZone getL31() {
        return l31;
    }

    public RectZone getL41() {
        return l41;
    }

    public RectZone getL2R() {
        return l2R;
    }

    public RectZone getL3R() {
        return l3R;
    }

    public RectZone getL4R() {
        return l4R;
    }

    public RectZone getL1R() {
        return l1R;
    }

    public RectZone getL4() {
        return l4;
    }

    public RectZone getL1() {
        return l1;
    }

    public RectZone getL2() {
        return l2;
    }

    public RectZone getL3() {
        return l3;
    }

    public RectZone getL432() {
        return l432;
    }

}
