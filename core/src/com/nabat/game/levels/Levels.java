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
    private final RectZone l1, l2, l3, l4; //квадраты на экране, символизирующие кнопки уровней
    private final RectZone l11, l21, l31, l41;
    private final RectZone l12, l22, l32, l42;
    private final RectZone l1R, l2R, l3R, l4R;
    private final LevelFactory lvl1, lvl11, lvl12, lvl1R;// сами уровни
    private final LevelFactory lvl2, lvl21, lvl22, lvl2R;
    private final LevelFactory lvl3, lvl31, lvl32, lvl3R;
    private final LevelFactory lvl4, lvl41, lvl42, lvl4R;
    private final BitmapFont font;
    private final Game game;
    private final ArrayList<RectZone> zoneList;

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

        int LEVEL_LEVEL = (Consts.getHEIGHT() / 6);
        l1 = new RectZone(Consts.getWIDTH() / 10,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l2 = new RectZone(Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l3 = new RectZone(Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l4 = new RectZone(Consts.getWIDTH() / 10,//Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        ////////////////////////////////
        l11 = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l21 = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l31 = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l41 = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        ////////////////////////////////
        l12 = new RectZone(Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l22 = new RectZone(Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l32 = new RectZone(Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l42 = new RectZone(Consts.getWIDTH() / 10 + 2 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);


        /////////////////////////////////////////////////
        int d = Consts.getWIDTH()/200;
        l1R = new RectZone(Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - d,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l2R = new RectZone(Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - d - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l3R = new RectZone(Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - d - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l4R = new RectZone(Consts.getWIDTH() / 10 + 3 * Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - d - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l1R.setRotation(true, 0.5f);
        l2R.setRotation(true, 0.5f);
        l3R.setRotation(true, 0.5f);
        l4R.setRotation(true, 0.5f);

        zoneList.add(l1);
        zoneList.add(l2);
        zoneList.add(l3);
        zoneList.add(l4);

        zoneList.add(l11);
        zoneList.add(l21);
        zoneList.add(l31);
        zoneList.add(l41);

        zoneList.add(l12);
        zoneList.add(l22);
        zoneList.add(l32);
        zoneList.add(l42);

        zoneList.add(l1R);
        zoneList.add(l2R);
        zoneList.add(l3R);
        zoneList.add(l4R);
    }

    public static void setLvl(int lvl) {
        Levels.lvl = lvl;
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
            case 12: { /////базовый набор уровней
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
