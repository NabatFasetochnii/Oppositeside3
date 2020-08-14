package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.nabat.game.Consts;
import com.nabat.game.Game;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForMenu;

import java.util.ArrayList;

public class Levels implements Screen {
    private static int lvl = 0;
    private final RectZone l1, l2, l3, l4; //квадраты на экране, символизирующие кнопки уровней //первая цифра - колво квадратов,  вторая - режим, третья - счётчик
    private final RectZone l11, l21, l31, l41;
    private final RectZone l111, l211, l311, l411; //уровни меньшей площади
    private final RectZone l12, l22, l32, l42;
    private final RectZone l121, l221, l321, l421;
    private final RectZone l122, l222, l322, l422;
    private final RectZone l1R, l2R, l3R, l4R;
    private final RectZone l1R1, l2R1, l3R1, l4R1;
    private final RectZone l1R2, l2R2, l3R2, l4R2;
    private final Game game;
    private final ArrayList<RectZone> zoneList;
    private final int zeroPoint;
    private final int endPoint;
    private int scrollX = 0;
    private final Color color1, color2, color3, color4;

    //TODO ДОБАВИТЬ ОЧИВКИ
    //TODO добавить сервисы гугл
    public Levels(Game game) {//TODO написать менюшку
        zoneList = new ArrayList<>();
        this.game = game;

        color1 = Color.FIREBRICK;
        color2 = Color.RED;//
        color3 = Color.LIME;
        color4 = Color.VIOLET;//

        Color color01 = new Color(Color.rgb888(0, 207, 0));
        Color color02 = new Color(Color.rgb888(0, 186, 0));
        Color color03 = new Color(Color.rgb888(0, 165, 0));

        Color color11 = new Color(Color.rgb888(0, 184, 151));
        Color color12 = new Color(Color.rgb888(0, 159, 135));
        Color color13 = new Color(Color.rgb888(0, 140, 129));

        Color color21 = new Color(Color.rgb888(253, 177, 0));
        Color color22 = new Color(Color.rgb888(240, 165, 0));
        Color color23 = new Color(Color.rgb888(232, 157, 0));

        zeroPoint = Consts.getWIDTH() / 10;

        int LEVEL_LEVEL = (Consts.getHEIGHT() / 6);
        l1 = new RectZone(scrollX + Consts.getWIDTH() / 10,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color01);

        l2 = new RectZone(scrollX + Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color01);

        l3 = new RectZone(scrollX + Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color01);

        l4 = new RectZone(scrollX + Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color01);

        ////////////////////////////////

        int c = 1;


        l11 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color02);

        l21 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color02);

        l31 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color02);

        l41 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color02);

        ////////////////////////////////
        c = 2;

        l111 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color03);

        l211 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color03);

        l311 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color03);

        l411 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color03);

        ////////////////////////////////
        c = 3;
        l12 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color11);

        l22 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color11);

        l32 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color11);

        l42 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color11);

        ////////////////////////////////
        c = 4;

        l121 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color12);

        l221 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color12);

        l321 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color12);

        l421 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color12);

        /////////////////////////////////////////////////

        c = 5;

        l122 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color13);

        l222 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color13);

        l322 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color13);

        l422 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color13);

        /////////////////////////////////////////////////
        c = 6;

        l1R = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color21);//new Color(116,73,255,100)


        l2R = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color21);

        l3R = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color21);

        l4R = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color21);

        /////////////////////////////////////////////////
        c = 7;

        l1R1 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color22);//new Color(116,73,255,100)


        l2R1 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color22);

        l3R1 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color22);

        l4R1 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color22);

        /////////////////////////////////////////////////
        c = 8;

        l1R2 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color23);//new Color(116,73,255,100)


        l2R2 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color23);

        l3R2 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color23);

        l4R2 = new RectZone(scrollX + Consts.getWIDTH() / 10 + c * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, color23);

        endPoint = Consts.getWIDTH() - zeroPoint - l1.getWidth();

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
    }

    public static void setLvl(int lvl) {
        Levels.lvl = lvl;
    }

    @Override
    public void render(float delta) {

        Consts.clear();

        for (RectZone r : zoneList) {
            r.draw();
        }

        game.getBatch().begin();

        float f = 1.3f;
        Consts.getFontForMenu().draw(game.getBatch(), "1", l1.getX() + l1.getWidth() / 3f, l1.getY() + l1.getHeight() / f);
        Consts.getFontForMenu().draw(game.getBatch(), "2", l2.getX() + l2.getWidth() / 4f, l2.getY() + l2.getHeight() / f);
        Consts.getFontForMenu().draw(game.getBatch(), "3", l3.getX() + l3.getWidth() / 4f, l3.getY() + l3.getHeight() / f);
        Consts.getFontForMenu().draw(game.getBatch(), "4", l4.getX() + l4.getWidth() / 4f, l4.getY() + l4.getHeight() / f);

        Consts.getFontForMenu().draw(game.getBatch(), "Sum of best: " + Consts.getCountOfAllPoints(), 50, Consts.getHEIGHT() - 50);

        game.getBatch().end();

        switch (lvl) {
            case 1: { /////базовый набор уровней
                LevelFactory lvl1 = new LevelFactory(color1,
                        20, Consts.getPathToFirst(), 100, 1, game, 1);
                game.setScreen(new InfoScreen(game, lvl1));
                lvl = 0;
                break;
            }
            case 2: {
                LevelFactory lvl2 = new LevelFactory(color2,
                        30, Consts.getPathToSecond(), 100, 2, game, 2);
                game.setScreen(new InfoScreen(game, lvl2));
                lvl = 0;
                break;
            }
            case 3: {
                LevelFactory lvl3 = new LevelFactory(color3,
                        30, Consts.getPathToThird(), 50, 3, game, 3);
                game.setScreen(new InfoScreen(game, lvl3));
                lvl = 0;
                break;
            }
            case 4: {
                LevelFactory lvl4 = new LevelFactory(color4,
                        40, Consts.getPathToFourth(), 50, 4, game, 4);

                game.setScreen(new InfoScreen(game, lvl4));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 11: { //продвинутый набор уровней
                LevelFactory lvl11 = new LevelFactory(color1,
                        30, Consts.getPathToFirst(), 200, 1, game, 11);
                game.setScreen(new InfoScreen(game, lvl11));
                lvl = 0;
                break;
            }
            case 21: {
                LevelFactory lvl21 = new LevelFactory(color2,
                        40, Consts.getPathToSecond(), 200, 2, game, 21);
                game.setScreen(new InfoScreen(game, lvl21));
                lvl = 0;
                break;
            }
            case 31: {
                LevelFactory lvl31 = new LevelFactory(color3,
                        50, Consts.getPathToThird(), 200, 3, game, 31);
                game.setScreen(new InfoScreen(game, lvl31));
                lvl = 0;
                break;
            }
            case 41: {
                LevelFactory lvl41 = new LevelFactory(color4,
                        60, Consts.getPathToFourth(), 200, 4, game, 41);
                game.setScreen(new InfoScreen(game, lvl41));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 111: { //продвинутый набор уровней
                LevelFactory lvl111 = new LevelFactory(color1,
                        30, Consts.getPathToFirstComplicated(), 200, 1, game, 11);
                game.setScreen(new InfoScreen(game, lvl111));
                lvl = 0;
                break;
            }
            case 211: {
                LevelFactory lvl211 = new LevelFactory(color2,
                        40, Consts.getPathToSecondComplicated(), 200, 2, game, 21);
                game.setScreen(new InfoScreen(game, lvl211));
                lvl = 0;
                break;
            }
            case 311: {
                LevelFactory lvl311 = new LevelFactory(color3,
                        50, Consts.getPathToThirdComplicated(), 200, 3, game, 31);
                game.setScreen(new InfoScreen(game, lvl311));
                lvl = 0;
                break;
            }
            case 411: {
                LevelFactory lvl411 = new LevelFactory(color4,
                        60, Consts.getPathToFourthComplicated(), 200, 4, game, 41);
                game.setScreen(new InfoScreen(game, lvl411));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 12: {

                LevelFactory lvl12 = new LevelFactory(color1,
                        20, Consts.getPathToFirst(), 100, 1, game, 12);
                lvl12.setDot(true);
                game.setScreen(new InfoScreen(game, lvl12));
                lvl = 0;
                break;
            }
            case 22: {

                LevelFactory lvl22 = new LevelFactory(color2,
                        30, Consts.getPathToSecond(), 100, 2, game, 22);
                lvl22.setDot(true);
                game.setScreen(new InfoScreen(game, lvl22));
                lvl = 0;
                break;
            }
            case 32: {
                LevelFactory lvl32 = new LevelFactory(color3,
                        30, Consts.getPathToThird(), 50, 3, game, 32);
                lvl32.setDot(true);
                game.setScreen(new InfoScreen(game, lvl32));
                lvl = 0;
                break;
            }
            case 42: {
                LevelFactory lvl42 = new LevelFactory(color3,
                        40, Consts.getPathToFourth(), 50, 4, game, 42);
                lvl42.setDot(true);
                game.setScreen(new InfoScreen(game, lvl42));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 121: {
                LevelFactory lvl121 = new LevelFactory(color1,
                        30, Consts.getPathToFirst(), 400, 1, game, 121);
                lvl121.setDot(true);
                game.setScreen(new InfoScreen(game, lvl121));
                lvl = 0;
                break;
            }
            case 221: {
                LevelFactory lvl221 = new LevelFactory(color2,
                        35, Consts.getPathToSecond(), 300, 2, game, 221);
                lvl221.setDot(true);
                game.setScreen(new InfoScreen(game, lvl221));
                lvl = 0;
                break;
            }
            case 321: {
                LevelFactory lvl321 = new LevelFactory(color3,
                        40, Consts.getPathToThird(), 150, 3, game, 321);
                lvl321.setDot(true);
                game.setScreen(new InfoScreen(game, lvl321));
                lvl = 0;
                break;
            }
            case 421: {
                LevelFactory lvl421 = new LevelFactory(color4,
                        40, Consts.getPathToFourth(), 100, 4, game, 421);
                lvl421.setDot(true);
                game.setScreen(new InfoScreen(game, lvl421));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 122: {
                LevelFactory lvl122 = new LevelFactory(color1,
                        30, Consts.getPathToFirstComplicated(), 400, 1, game, 122);
                lvl122.setDot(true);
                game.setScreen(new InfoScreen(game, lvl122));
                lvl = 0;
                break;
            }
            case 222: {
                LevelFactory lvl222 = new LevelFactory(color2,
                        35, Consts.getPathToSecondComplicated(), 300, 2, game, 222);
                lvl222.setDot(true);

                game.setScreen(new InfoScreen(game, lvl222));
                lvl = 0;
                break;
            }
            case 322: {
                LevelFactory lvl322 = new LevelFactory(color3,
                        40, Consts.getPathToThirdComplicated(), 150, 3, game, 322);
                lvl322.setDot(true);
                game.setScreen(new InfoScreen(game, lvl322));
                lvl = 0;
                break;
            }
            case 422: {
                LevelFactory lvl422 = new LevelFactory(color4,
                        40, Consts.getPathToFourthComplicated(), 100, 4, game, 422);
                lvl422.setDot(true);
                game.setScreen(new InfoScreen(game, lvl422));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 10: { //набор уровней с кручением

                LevelFactory lvl1R = new LevelFactory(color1,
                        40, Consts.getPathToFirstRotation(), 300, 1, game, 10);
                lvl1R.setRotation(true, 5);
                game.setScreen(new InfoScreen(game, lvl1R));
                lvl = 0;
                break;
            }
            case 20: {
                LevelFactory lvl2R = new LevelFactory(color2,
                        60, Consts.getPathToSecondRotation(), 100, 2, game, 20);
                lvl2R.setRotation(true, 2);
                game.setScreen(new InfoScreen(game, lvl2R));
                lvl = 0;
                break;
            }

            case 30: {
                LevelFactory lvl3R = new LevelFactory(color3,
                        60, Consts.getPathToThirdRotation(), 100, 3, game, 30);
                lvl3R.setRotation(true, 1);
                game.setScreen(new InfoScreen(game, lvl3R));
                lvl = 0;
                break;
            }
            case 40: {
                LevelFactory lvl4R = new LevelFactory(color4,
                        50, Consts.getPathToFourthRotation(), 50, 4, game, 40);
                lvl4R.setRotation(true, 0.5f);
                game.setScreen(new InfoScreen(game, lvl4R));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 101: { //набор уровней с кручением

                LevelFactory lvl1R1 = new LevelFactory(color4,
                        80, Consts.getPathToFirstRotation(), 500, 1, game, 101);
                lvl1R1.setRotation(true, 4);
                game.setScreen(new InfoScreen(game, lvl1R1));
                lvl = 0;
                break;
            }
            case 201: {
                LevelFactory lvl2R1 = new LevelFactory(color2,
                        80, Consts.getPathToSecondRotation(), 200, 2, game, 201);
                lvl2R1.setRotation(true, 2);
                game.setScreen(new InfoScreen(game, lvl2R1));
                lvl = 0;
                break;
            }

            case 301: {

                LevelFactory lvl3R1 = new LevelFactory(color3,
                        80, Consts.getPathToThirdRotation(), 150, 3, game, 301);
                lvl3R1.setRotation(true, 1);
                game.setScreen(new InfoScreen(game, lvl3R1));
                lvl = 0;
                break;
            }
            case 401: {
                LevelFactory lvl4R1 = new LevelFactory(color4,
                        80, Consts.getPathToFourthRotation(), 100, 4, game, 401);
                lvl4R1.setRotation(true, 0.5f);
                game.setScreen(new InfoScreen(game, lvl4R1));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 102: { //набор уровней с кручением

                // сами уровни
                LevelFactory lvl1R2 = new LevelFactory(color1,
                        100, Consts.getPathToFirstRotationComplicated(), 600, 1, game, 102);
                lvl1R2.setRotation(true, 3);
                game.setScreen(new InfoScreen(game, lvl1R2));
                lvl = 0;
                break;
            }
            case 202: {
                LevelFactory lvl2R2 = new LevelFactory(color2,
                        100, Consts.getPathToSecondRotationComplicated(), 300, 2, game, 202);
                lvl2R2.setRotation(true, 1);
                game.setScreen(new InfoScreen(game, lvl2R2));
                lvl = 0;
                break;
            }

            case 302: {
                LevelFactory lvl3R2 = new LevelFactory(color3,
                        100, Consts.getPathToThirdRotationComplicated(), 200, 3, game, 302);
                lvl3R2.setRotation(true, 0.5f);
                game.setScreen(new InfoScreen(game, lvl3R2));
                lvl = 0;
                break;
            }
            case 402: {
                LevelFactory lvl4R2 = new LevelFactory(color4,
                        100, Consts.getPathToFourthRotationComplicated(), 200, 4, game, 402);
                lvl4R2.setRotation(true, 0.25f);
                game.setScreen(new InfoScreen(game, lvl4R2));
                lvl = 0;
                break;
            }
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

    public int getScrollX() {
        return scrollX;
    }

    /////////scroll
    public void setScrollX(int scrollX) {

        if (l1.getX() - scrollX < zeroPoint && l1R2.getX() - scrollX > endPoint) {

            this.scrollX = scrollX;
            for (RectZone r : zoneList) {
                r.setX(r.getX() - scrollX);
            }
        }

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

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputForMenu(this));
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

        l1.dispose();
        l2.dispose();
        l3.dispose();
        l4.dispose();
        l1R.dispose();
    }
}
