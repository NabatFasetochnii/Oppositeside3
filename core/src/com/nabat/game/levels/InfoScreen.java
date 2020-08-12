package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.nabat.game.Consts;
import com.nabat.game.Game;
import com.nabat.game.RectZone;

public class InfoScreen implements Screen {

    private final Game game;
    private final LevelFactory levelFactory;
    private final BitmapFont bitmapFont;
    private final RectZone startGame;
    private final RectZone backToMenu;
    private boolean start = false;
    private boolean back = false;
    private String info;

    InfoScreen(Game game, LevelFactory levelFactory, BitmapFont bitmapFont) {

        this.game = game;
        this.levelFactory = levelFactory;
        this.bitmapFont = bitmapFont;

        startGame = new RectZone(Consts.getWIDTH() / 20, (int) (Consts.getHEIGHT() * 0.1f),
                Consts.getWIDTH() / 8, Consts.getWIDTH() / 8, Color.FOREST);
        backToMenu = new RectZone((int) (Consts.getWIDTH() * (19f / 20f)) - Consts.getWIDTH() / 8,
                (int) (Consts.getHEIGHT() * 0.1f),
                Consts.getWIDTH() / 8,
                Consts.getWIDTH() / 8, Color.CORAL);

        int complexity = levelFactory.getLvl();

        if (levelFactory.isRotation()&&levelFactory.isDot()) {
            complexity *= 4;
        }else if (levelFactory.isRotation()||levelFactory.isDot()) {
            complexity *= 2;
        }
        info = "INFO: " + '\n' + "Complexity: " + complexity + '\n' +
                "Duration: " + levelFactory.getLevelTime() + "s" + '\n' +
                "Size: " + levelFactory.getSizeOfScreens() + '\n';

        switch (levelFactory.getLvlName()) {

            case 1: {


                info += "Best score: " + Consts.getCountOfPoints1();

                break;
            }
            case 2: {
                info += "Best score: " + Consts.getCountOfPoints2();

                break;
            }
            case 3: {


                info += "Best score: " + Consts.getCountOfPoints3();
                break;
            }
            case 4: {

                info += "Best score: " + Consts.getCountOfPoints4();


                break;
            }
            ////////////////////////////////////////
            case 11: { //продвинутый набор уровней


                info += "Best score: " + Consts.getCountOfPoints11();
                break;
            }
            case 21: {


                info += "Best score: " + Consts.getCountOfPoints21();
                break;
            }
            case 31: {

                info += "Best score: " + Consts.getCountOfPoints31();

                break;
            }
            case 41: {


                info += "Best score: " + Consts.getCountOfPoints41();

                break;
            }
            ////////////////////////////////////////

            case 111: { //продвинутый набор уровней


                info += "Best score: " + Consts.getCountOfPoints111();
                break;
            }
            case 211: {


                info += "Best score: " + Consts.getCountOfPoints211();
                break;
            }
            case 311: {


                info += "Best score: " + Consts.getCountOfPoints311();
                break;
            }
            case 411: {

                info += "Best score: " + Consts.getCountOfPoints411();
                break;
            }

            ////////////////////////////////////////
            case 12: {


                info += "Best score: " + Consts.getCountOfPoints12();

                break;
            }
            case 22: {


                info += "Best score: " + Consts.getCountOfPoints22();
                break;
            }
            case 32: {


                info += "Best score: " + Consts.getCountOfPoints32();
                break;
            }
            case 42: {

                info += "Best score: " + Consts.getCountOfPoints42();

                break;
            }
            ////////////////////////////////////////

            case 121: { //продвинутый набор уровней

                info += "Best score: " + Consts.getCountOfPoints121();
                break;
            }
            case 221: {

                info += "Best score: " + Consts.getCountOfPoints221();
                break;
            }
            case 321: {

                info += "Best score: " + Consts.getCountOfPoints321();
                break;
            }
            case 421: {

                info += "Best score: " + Consts.getCountOfPoints421();
                break;
            }

            ////////////////////////////////////////
            case 122: { //продвинутый набор уровней
                info += "Best score: " + Consts.getCountOfPoints122();
                break;
            }
            case 222: {
                info += "Best score: " + Consts.getCountOfPoints222();
                break;
            }
            case 322: {
                info += "Best score: " + Consts.getCountOfPoints322();
                break;
            }
            case 422: {

                info += "Best score: " + Consts.getCountOfPoints422();
                break;
            }

            ////////////////////////////////////////
            case 10: { //набор уровней с кручением
                info += "Best score: " + Consts.getCountOfPoints1R();
                break;
            }
            case 20: {
                info += "Best score: " + Consts.getCountOfPoints2R();

                break;
            }

            case 30: {

                info += "Best score: " + Consts.getCountOfPoints3R();
                break;
            }
            case 40: {

                info += "Best score: " + Consts.getCountOfPoints4R();
                break;
            }
            ////////////////////////////////////////

        }

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                if (startGame.isTouch(screenX, Consts.getHEIGHT() - screenY)) {
                    start = true;
                } else if (backToMenu.isTouch(screenX, Consts.getHEIGHT() - screenY)) {
                    back = true;
                }


                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });
    }

    /**/
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 255, 0, 1); //чтобы добиться кека в скрине НЕ нужно писать эти две строки
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        backToMenu.draw();
        startGame.draw();

        game.getBatch().begin();


        bitmapFont.draw(game.getBatch(), info,
                Consts.getWIDTH() / 20f, Consts.getHEIGHT() * 0.9f);
        game.getBatch().end();


        if (start) {
            game.setScreen(levelFactory);

        }
        if (back) {
            game.setScreen(game.getLevels());
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

    @Override
    public void dispose() {

        game.dispose();
        levelFactory.dispose();

    }
}
