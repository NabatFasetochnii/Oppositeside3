package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.nabat.game.Consts;
import com.nabat.game.Game;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForMenu;

public class Levels implements Screen {
    private static int lvl = 0;
    private final RectZone l1;
    private final RectZone l1R;
    private final RectZone l2R;
    private final RectZone l3R;
    private final RectZone l4R;
    private final RectZone l2;
    private final RectZone l3;
    private final RectZone l4;
    private final LevelFactory lvl1, lvl1R;
    private final LevelFactory lvl2, lvl2R;
    private final LevelFactory lvl3, lvl3R;
    private final LevelFactory lvl4, lvl4R;
    private final BitmapFont font;
    private final Game game;
    public Levels(Game game) {//TODO написать менюшку

        this.game = game;
        this.lvl1 = new LevelFactory(Color.RED,
                20, Consts.getPathToFirst(), 400, 1, game);

        this.lvl2 = new LevelFactory(Color.GREEN,
                20, Consts.getPathToSecond(), 200, 2, game);

        this.lvl3 = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToThird(), 100, 3, game);

        this.lvl4 = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToFourth(), 100, 4, game);

        lvl1R = new LevelFactory(Color.RED,
                20, Consts.getPathToFirstRotation(), 400, 1, game);

        lvl2R = new LevelFactory(Color.GREEN,
                20, Consts.getPathToSecondRotation(), 100, 2, game);

        lvl3R = new LevelFactory(Color.OLIVE,
                20, Consts.getPathToThirdRotation(), 100, 3, game);
        lvl4R = new LevelFactory(Color.OLIVE,
                30, Consts.getPathToFourthRotation(), 100, 4, game);

        lvl1R.setRotation(true, 3);
        lvl2R.setRotation(true, 3);
        lvl3R.setRotation(true, 3);
        lvl4R.setRotation(true, 3);

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

        l1R = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l2R = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l3R = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 2 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

        l4R = new RectZone(Consts.getWIDTH() / 10 + Consts.getWIDTH() / 5,
                Consts.getHEIGHT() - LEVEL_LEVEL - 3 * Consts.getWIDTH() / 5,
                Consts.getWIDTH() / 10,
                Consts.getWIDTH() / 10, Color.RED);

    }

    public static void setLvl(int lvl) {
        Levels.lvl = lvl;
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

        Gdx.gl.glClearColor(255, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        l1.draw();
        l2.draw();
        l3.draw();
        l4.draw();
        l1R.draw();
        l2R.draw();
        l3R.draw();
        l4R.draw();

        game.getBatch().begin();

        float f = 1.3f;
        font.draw(game.getBatch(), "1", l1.getX() + l1.getWidth() / 3f, l1.getY() + l1.getHeight() / f);
        font.draw(game.getBatch(), "2", l2.getX() + l2.getWidth() / 4f, l2.getY() + l2.getHeight() / f);
        font.draw(game.getBatch(), "3", l3.getX() + l3.getWidth() / 4f, l3.getY() + l3.getHeight() / f);
        font.draw(game.getBatch(), "4", l4.getX() + l4.getWidth() / 4f, l4.getY() + l4.getHeight() / f);

        font.draw(game.getBatch(), "Sum of best: " + Consts.getCountOfAllPoints(), 50, Consts.getHEIGHT() - 50);

        game.getBatch().end();

        switch (lvl) {
            case 1: {
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
            case 10: {
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
