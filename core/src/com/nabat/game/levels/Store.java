package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;

public class Store implements Screen {

/*    private final int rectsS;
    private final MyGame myGame;
//    private final Information info;
    private final String RESTORE = "Restore";
    private final float nameX;
    private final float nameY;
    private final float priceX;
    private final float priceY;
    private final float restoreX;
    private final float restoreY;
    private final RectZone priceButton;
    private final RectZone restoreButton;*/

    public Store(MyGame myGame) {

/*        this.myGame = myGame;
//        info = myGame.purchaseManager.getInformation(myGame.getSKU());
        rectsS = Consts.getWIDTH() / 10;
        float d = Consts.getWIDTH() / 20f;

//        GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForMenu(), info.getLocalPricing());
        nameX = d * 2;
        nameY = Consts.getHEIGHT() - rectsS - d;
        priceY = nameY;
        priceX = Consts.getWIDTH() - d - glyphLayout.width;
        restoreX = d * 2;
        restoreY = d * 2;
//        Information.UNAVAILABLE
        priceButton = new RectZone(priceX - d, priceY - d,
                glyphLayout.width + d * 2, glyphLayout.height + d * 2, Color.RED);

        glyphLayout = new GlyphLayout(Consts.getFontForMenu(), RESTORE);

        restoreButton = new RectZone(restoreX - d, restoreY - d,
                glyphLayout.width + d * 2, glyphLayout.height + d * 2, Color.RED);*/
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
                int y = Consts.getHEIGHT() - screenY;
/*

                if (priceButton.isTouch(screenX, y)) {

                    //TODO СЛЫШ КУПИ
                }

                if (restoreButton.isTouch(screenX, y)) {
                    //TODO СЛЫШ ВЕРНИ

                }

                if (Consts.isTouch(Consts.getWIDTH() - rectsS,
                        Consts.getHEIGHT() - rectsS, rectsS, rectsS, screenX, y)) {

                    myGame.setScreen(new Start(myGame));
                    dispose();
                }
*/

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

       /* priceButton.draw();
        restoreButton.draw();

        myGame.getBatch().begin();
        myGame.getBatch().draw(Loader.getSettingsButton(),
                Consts.getWIDTH() - rectsS, Consts.getHEIGHT() - rectsS, rectsS, rectsS);

        Consts.getFontForMenu().draw(myGame.getBatch(), info.getLocalName(), nameX, nameY);
        Consts.getFontForMenu().draw(myGame.getBatch(), info.getLocalPricing(), priceX, priceY);
        Consts.getFontForMenu().draw(myGame.getBatch(), RESTORE, restoreX, restoreY);

        myGame.getBatch().end();*/
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
//        priceButton.dispose();
    }
}
