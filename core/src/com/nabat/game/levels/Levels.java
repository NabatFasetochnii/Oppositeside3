package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.nabat.game.Consts;
import com.nabat.game.Game;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForMenu;

import java.util.ArrayList;

public class Levels implements Screen {
    private static int lvl = 0;
    private final RectZone l1, l2, l3, l4; //квадраты на экране, символизирующие кнопки уровней //первая цифра - колво квадратов,  вторая - режим, третья - счётчик
    private final RectZone l11, l21, l31, l41;
    private final RectZone l111; //уровни меньшей площади
    private final RectZone l211;
    private final RectZone l311;
    private final RectZone l411;
    private final RectZone l12, l22, l32, l42;
    private final RectZone l121, l221, l321, l421;
    private final RectZone l122, l222, l322, l422;
    private final RectZone l1R, l2R, l3R, l4R;
    private final LevelFactory lvl1, lvl11, lvl111, lvl12, lvl121, lvl122, lvl1R;// сами уровни
    private final LevelFactory lvl2, lvl21, lvl211, lvl22, lvl221, lvl222, lvl2R;
    private final LevelFactory lvl3, lvl31, lvl311, lvl32, lvl321, lvl322, lvl3R;
    private final LevelFactory lvl4, lvl41, lvl411, lvl42, lvl421, lvl422, lvl4R;
    private final BitmapFont font;
    private final Game game;
    private final ArrayList<RectZone> zoneList;
    private int scrollX = 0;
    private final int zeroPoint;
    private final int endPoint;

    public Levels(Game game) {//TODO написать менюшку
        zoneList = new ArrayList<>();
        this.game = game;

        lvl1 = new LevelFactory(Color.RED,
                20, Consts.getPathToFirst(), 100, 1, game, 1);
        lvl2 = new LevelFactory(Color.GREEN,
                20, Consts.getPathToSecond(), 100, 2, game, 2);
        lvl3 = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToThird(), 50, 3, game, 3);
        lvl4 = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToFourth(), 50, 4, game, 4);

        lvl11 = new LevelFactory(Color.RED,
                30, Consts.getPathToFirst(), 200, 1, game, 11);
        lvl21 = new LevelFactory(Color.GREEN,
                30, Consts.getPathToSecond(), 200, 2, game, 21);
        lvl31 = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToThird(), 200, 3, game, 31);
        lvl41 = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToFourth(), 200, 4, game, 41);

        lvl111 = new LevelFactory(Color.RED,
                30, Consts.getPathToFirst(), 200, 1, game, 11);//TODO ПОМЕНЯТЬ ФАЙЛ НА ТОТ, ЧТО С КВАДРАТАМИ МЕНЬШЕЙ ПЛОЩАДИ
        lvl211 = new LevelFactory(Color.GREEN,
                30, Consts.getPathToSecond(), 200, 2, game, 21);
        lvl311 = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToThird(), 200, 3, game, 31);
        lvl411 = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToFourth(), 200, 4, game, 41);

        lvl12 = new LevelFactory(Color.RED,
                20, Consts.getPathToFirst(), 100, 1, game, 12);
        lvl22 = new LevelFactory(Color.GREEN,
                20, Consts.getPathToSecond(), 100, 2, game, 22);
        lvl32 = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToThird(), 50, 3, game, 32);
        lvl42 = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToFourth(), 50, 4, game, 42);

        lvl12.setDot(true);
        lvl22.setDot(true);
        lvl32.setDot(true);
        lvl42.setDot(true);

        lvl121 = new LevelFactory(Color.RED,
                30, Consts.getPathToFirst(), 400, 1, game, 121);
        lvl221 = new LevelFactory(Color.GREEN,
                35, Consts.getPathToSecond(), 300, 2, game, 221);
        lvl321 = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToThird(), 150, 3, game, 321);
        lvl421 = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToFourth(), 100, 4, game, 421);

        lvl121.setDot(true);
        lvl221.setDot(true);
        lvl321.setDot(true);
        lvl421.setDot(true);

        lvl122 = new LevelFactory(Color.RED,
                30, Consts.getPathToFirst(), 400, 1, game, 122);//TODO ПОМЕНЯТЬ ФАЙЛ НА ТОТ, ЧТО С КВАДРАТАМИ МЕНЬШЕЙ ПЛОЩАДИ
        lvl222 = new LevelFactory(Color.GREEN,
                35, Consts.getPathToSecond(), 300, 2, game, 222);
        lvl322 = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToThird(), 150, 3, game, 322);
        lvl422 = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToFourth(), 100, 4, game, 422);

        lvl122.setDot(true);
        lvl222.setDot(true);
        lvl322.setDot(true);
        lvl422.setDot(true);


        lvl1R = new LevelFactory(Color.RED,
                40, Consts.getPathToFirstRotation(), 300, 1, game, 10);
        lvl2R = new LevelFactory(Color.GREEN,
                40, Consts.getPathToSecondRotation(), 100, 2, game, 20);
        lvl3R = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToThirdRotation(), 100, 3, game, 30);
        lvl4R = new LevelFactory(Color.OLIVE,
                40, Consts.getPathToFourthRotation(), 50, 4, game, 40);

        lvl1R.setRotation(true, 4);
        lvl2R.setRotation(true, 2);
        lvl3R.setRotation(true, 1);
        lvl4R.setRotation(true, 0.5f);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Gdx.app.getGraphics().getWidth() / 12;
        parameter.color = Color.CHARTREUSE;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        font = generator.generateFont(parameter);
        generator.dispose();

        Color color01 = new Color(Color.rgb888(0,207,0));
        Color color02 = new Color(Color.rgb888(0,186,0));
        Color color03 = new Color(Color.rgb888(0,165,0));

        Color color11 = new Color(Color.rgb888(0,184,151));
        Color color12 = new Color(Color.rgb888(0,159,135));
        Color color13 = new Color(Color.rgb888(0,140,129));

        Color color21 = new Color(Color.rgb888(253,177,0));
        /*Color color22 = new Color(Color.rgb888(247,170,0));
        Color color23 = new Color(Color.rgb888(241,163,0));*/

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

        endPoint = l12.getX();

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
    }

    public static void setLvl(int lvl) {
        Levels.lvl = lvl;
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

    public void setScrollX(int scrollX) {

        if (l1.getX() - scrollX < zeroPoint && l1R.getX() - scrollX > endPoint) {

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
    public void render(float delta) {

        Consts.clear();

        for (RectZone r : zoneList) {
            r.draw();
        }

        game.getBatch().begin();

        float f = 1.3f;
        font.draw(game.getBatch(), "1", l1.getX() + l1.getWidth() / 3f, l1.getY() + l1.getHeight() / f);
        font.draw(game.getBatch(), "2", l2.getX() + l2.getWidth() / 4f, l2.getY() + l2.getHeight() / f);
        font.draw(game.getBatch(), "3", l3.getX() + l3.getWidth() / 4f, l3.getY() + l3.getHeight() / f);
        font.draw(game.getBatch(), "4", l4.getX() + l4.getWidth() / 4f, l4.getY() + l4.getHeight() / f);

        font.draw(game.getBatch(), "Sum of best: " + Consts.getCountOfAllPoints(), 50, Consts.getHEIGHT() - 50);

        game.getBatch().end();

        switch (lvl) {
            case 1: { /////базовый набор уровней
                game.setScreen(new InfoScreen(game, lvl1, font));
                lvl = 0;
                break;
            }
            case 2: {
                game.setScreen(new InfoScreen(game, lvl2, font));
                lvl = 0;
                break;
            }
            case 3: {
                game.setScreen(new InfoScreen(game, lvl3, font));
                lvl = 0;
                break;
            }
            case 4: {

                game.setScreen(new InfoScreen(game, lvl4, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 11: { //продвинутый набор уровней
                game.setScreen(new InfoScreen(game, lvl11, font));
                lvl = 0;
                break;
            }
            case 21: {
                game.setScreen(new InfoScreen(game, lvl21, font));
                lvl = 0;
                break;
            }
            case 31: {
                game.setScreen(new InfoScreen(game, lvl31, font));
                lvl = 0;
                break;
            }
            case 41: {

                game.setScreen(new InfoScreen(game, lvl41, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 111: { //продвинутый набор уровней
                game.setScreen(new InfoScreen(game, lvl111, font));
                lvl = 0;
                break;
            }
            case 211: {
                game.setScreen(new InfoScreen(game, lvl211, font));
                lvl = 0;
                break;
            }
            case 311: {
                game.setScreen(new InfoScreen(game, lvl311, font));
                lvl = 0;
                break;
            }
            case 411: {

                game.setScreen(new InfoScreen(game, lvl411, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 12: {
                game.setScreen(new InfoScreen(game, lvl12, font));
                lvl = 0;
                break;
            }
            case 22: {
                game.setScreen(new InfoScreen(game, lvl22, font));
                lvl = 0;
                break;
            }
            case 32: {
                game.setScreen(new InfoScreen(game, lvl32, font));
                lvl = 0;
                break;
            }
            case 42: {

                game.setScreen(new InfoScreen(game, lvl42, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 121: {
                game.setScreen(new InfoScreen(game, lvl121, font));
                lvl = 0;
                break;
            }
            case 221: {
                game.setScreen(new InfoScreen(game, lvl221, font));
                lvl = 0;
                break;
            }
            case 321: {
                game.setScreen(new InfoScreen(game, lvl321, font));
                lvl = 0;
                break;
            }
            case 421: {

                game.setScreen(new InfoScreen(game, lvl421, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 122: {
                game.setScreen(new InfoScreen(game, lvl122, font));
                lvl = 0;
                break;
            }
            case 222: {
                game.setScreen(new InfoScreen(game, lvl222, font));
                lvl = 0;
                break;
            }
            case 322: {
                game.setScreen(new InfoScreen(game, lvl322, font));
                lvl = 0;
                break;
            }
            case 422: {

                game.setScreen(new InfoScreen(game, lvl422, font));
                lvl = 0;
                break;
            }
            ////////////////////////////////////////
            case 10: { //набор уровней с кручением
                game.setScreen(new InfoScreen(game, lvl1R, font));
                lvl = 0;
                break;
            }
            case 20: {

                game.setScreen(new InfoScreen(game, lvl2R, font));
                lvl = 0;
                break;
            }

            case 30: {

                game.setScreen(new InfoScreen(game, lvl3R, font));
                lvl = 0;
                break;
            }
            case 40: {

                game.setScreen(new InfoScreen(game, lvl4R, font));
                lvl = 0;
                break;
            }
        }

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
