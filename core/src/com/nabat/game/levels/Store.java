package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.pay.Information;
import com.nabat.game.Consts;
import com.nabat.game.Loader;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;

public class Store implements Screen {

    private final int rectsS;
    private final MyGame myGame;
    private final Information info;
    private final String RESTORE = "Restore";
    private final float nameX;
    private final float nameY;
    private final float priceX;
    private final float priceY;
    private final float restoreX;
    private final float restoreY;
    private final RectZone priceButton;
    private final RectZone restoreButton;

    public Store(MyGame myGame) {

        this.myGame = myGame;
        info = myGame.purchaseManager.getInformation(myGame.getSKU());
        rectsS = Consts.getWIDTH() / 10;
        float d = Consts.getWIDTH() / 30f;
        GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForStore(), info.getLocalPricing());
        nameX = d * 2;
        nameY = Consts.getHEIGHT() - rectsS - d;
        priceY = nameY;
        priceX = Consts.getWIDTH() - d * 2 - glyphLayout.width;
        restoreX = d * 2;
        restoreY = nameY - glyphLayout.height - d * 4;
//        Information.UNAVAILABLE
        priceButton = new RectZone(priceX - d, priceY - d * 2f,
                glyphLayout.width + d * 2, glyphLayout.height + d * 2, Color.RED);

        glyphLayout = new GlyphLayout(Consts.getFontForStore(), RESTORE);

        restoreButton = new RectZone(restoreX - d, restoreY - d * 2,
                glyphLayout.width + d * 2, glyphLayout.height + d * 2, Color.RED);
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
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                Consts.time = 0;
                int y = Gdx.app.getGraphics().getHeight() - screenY;


                if (priceButton.isTouch(screenX, y)) {

                    myGame.purchaseManager.purchase(myGame.getSKU());
                    //TODO СЛЫШ КУПИ
                }

                if (restoreButton.isTouch(screenX, y)) {
                    //TODO СЛЫШ ВЕРНИ
                    myGame.purchaseManager.purchaseRestore();
                }

                if (Consts.isTouch(Consts.getWIDTH() - rectsS,
                        Consts.getHEIGHT() - rectsS, rectsS, rectsS, screenX, y)) {

                    myGame.setScreen(new Start(myGame));
                    dispose();
                }

                return true;
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
        priceButton.draw();
        restoreButton.draw();

        myGame.getBatch().begin();
        myGame.getBatch().draw(Loader.getSettingsButton(),
                Consts.getWIDTH() - rectsS, Consts.getHEIGHT() - rectsS, rectsS, rectsS);

        Consts.getFontForStore().draw(myGame.getBatch(), "Disable ads", nameX, nameY);
        Consts.getFontForStore().draw(myGame.getBatch(), info.getLocalPricing(), priceX, priceY);
        Consts.getFontForStore().draw(myGame.getBatch(), RESTORE, restoreX, restoreY);

        myGame.getBatch().end();
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
        priceButton.dispose();
    }
}
