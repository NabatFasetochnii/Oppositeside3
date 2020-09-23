package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;

public class InfoScreen implements Screen {

    private final MyGame myGame;
    private final LevelFactory levelFactory;
    private final RectZone startGame;
    private final RectZone backToMenu;
    private boolean start = false;
    private boolean back = false;
    private String info;

    InfoScreen(MyGame myGame, LevelFactory levelFactory) {

        this.myGame = myGame;
        this.levelFactory = levelFactory;

        backToMenu = new RectZone(Consts.getWIDTH() / 20, (int) (Consts.getHEIGHT() * 0.2f),
                Consts.getWIDTH() / 8, Consts.getWIDTH() / 8, Color.CORAL);
        startGame = new RectZone((int) (Consts.getWIDTH() * (19f / 20f)) - Consts.getWIDTH() / 8,
                (int) (Consts.getHEIGHT() * 0.2f),
                Consts.getWIDTH() / 8,
                Consts.getWIDTH() / 8, Color.FOREST);

        int complexity = levelFactory.getLvl();

        if (levelFactory.isRotation() && levelFactory.isDot()) {
            complexity *= 4;
        } else if (levelFactory.isRotation() || levelFactory.isDot()) {
            complexity *= 2;
        }
        if (myGame.isRu) {
            info = "ИНФОРМАЦИЯ " + '\n' + "*Сложность: " + complexity + '\n' +
                    "*Время: " + levelFactory.getLevelTime() + "с" + '\n' +
                    "*Размер: " + levelFactory.getSizeOfScreens() + '\n' +
                    "*Очки: " + levelFactory.getSizeOfScreens() * levelFactory.getLvl() + '\n' +
                    "*Лучший счёт: ";
        } else {
            info = "INFO " + '\n' + "*Complexity: " + complexity + '\n' +
                    "*Duration: " + levelFactory.getLevelTime() + "s" + '\n' +
                    "*Size: " + levelFactory.getSizeOfScreens() + '\n' +
                    "*Points: " + levelFactory.getSizeOfScreens() * levelFactory.getLvl() + '\n' +
                    "*Best score: ";
        }

        switch (levelFactory.getLvlName()) {

            case 1: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT1()));
                break;
            }
            case 2: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT2()));
                break;
            }
            case 3: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT3()));
                break;
            }
            case 4: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT4()));
                break;
            }
            ////////////////////////////////////////
            case 11: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT11()));
                break;
            }
            case 21: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT21()));
                break;
            }
            case 31: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT31()));
                break;
            }
            case 41: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT41()));
                break;
            }
            ////////////////////////////////////////

            case 111: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT111()));
                break;
            }
            case 211: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT211()));
                break;
            }
            case 311: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT311()));
                break;
            }
            case 411: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT411()));
                break;
            }
            ////////////////////////////////////////
            case 12: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT12()));
                break;
            }
            case 22: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT22()));
                break;
            }
            case 32: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT32()));
                break;
            }
            case 42: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT42()));
                break;
            }
            ////////////////////////////////////////

            case 121: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT121()));
                break;
            }
            case 221: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT221()));
                break;
            }
            case 321: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT321()));
                break;
            }
            case 421: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT421()));
                break;
            }
            ////////////////////////////////////////
            case 122: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT122()));
                break;
            }
            case 222: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT222()));
                break;
            }
            case 322: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT322()));
                break;
            }
            case 422: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT422()));
                break;
            }
            ////////////////////////////////////////
            case 10: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT1R()));
                break;
            }
            case 20: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT2R()));
                break;
            }
            case 30: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT3R()));
                break;
            }
            case 40: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT4R()));
                break;
            }
            ////////////////////////////////////////
            case 101: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT1R1()));
                break;
            }
            case 201: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT2R1()));
                break;
            }
            case 301: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT3R1()));
                break;
            }
            case 401: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT4R1()));
                break;
            }
            ////////////////////////////////////////
            case 102: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT1R2()));
                break;
            }
            case 202: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT2R2()));
                break;
            }
            case 302: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT3R2()));
                break;
            }
            case 402: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT4R2()));
                break;
            }
            ////////////////////////////////////////
            case 13: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT13()));
                break;
            }
            case 23: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT23()));
                break;
            }
            case 33: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT33()));
                break;
            }
            case 43: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT43()));
                break;
            }
            ////////////////////////////////////////

            case 131: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT131()));
                break;
            }
            case 231: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT231()));
                break;
            }
            case 331: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT331()));
                break;
            }
            case 431: {

                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT431()));
                break;
            }
            ////////////////////////////////////////
            case 132: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT132()));
                break;
            }
            case 232: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT232()));
                break;
            }
            case 332: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT332()));
                break;
            }
            case 432: {
                info += String.valueOf(Consts.getMap().get(Consts.getCOUNT432()));
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

                if (startGame.isTouch(screenX, Gdx.app.getGraphics().getHeight() - screenY)) {
                    start = true;
                } else if (backToMenu.isTouch(screenX, Gdx.app.getGraphics().getHeight() - screenY)) {
                    back = true;
                }
                myGame.isFirst = true;

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


    @Override
    public void render(float delta) {

        Consts.clear();
        myGame.showAdToAFK();

        backToMenu.draw();
        startGame.draw();

        myGame.getBatch().begin();
        myGame.loader.getFontForMenu().draw(myGame.getBatch(), info,
                Consts.getWIDTH() / 20f, Consts.getHEIGHT() * 0.9f);
        myGame.getBatch().end();

        Consts.time += Gdx.graphics.getDeltaTime();
        if (Consts.time >= 3600) {
            myGame.gsClient.unlockAchievement(Consts.getTakeThought());
        }
        Consts.timeSpeed += Gdx.graphics.getDeltaTime();
        if (start) {
            if (!Consts.isRemoveAds()) {
                myGame.getAdsController().loadBanner();
            }

//            myGame.getAdsController().hideBannerForStart();
            myGame.setScreen(levelFactory);
            dispose();
        }
        if (back) {
            myGame.setScreen(myGame.getLevels());
            dispose();
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
        startGame.dispose();
        backToMenu.dispose();
        levelFactory.dispose();

    }
}
