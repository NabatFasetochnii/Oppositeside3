package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.Prosak;
import com.nabat.game.Start;
import de.golfgl.gdxgamesvcs.gamestate.ILoadGameStateResponseListener;

import java.util.Map;

public class LoadingScreen implements Screen {

    private final MyGame myGame;

    public LoadingScreen(MyGame myGame) {

        this.myGame = myGame;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Consts.clear();//TODO ГИФОЧКУ БЫ КАКУЮНИТЬ ИЛИ ЛОГОТИП ХЗ

        if (myGame.gsClient.isSessionActive()) {

            try {

                myGame.gsClient.loadGameState(Consts.getPrefName(), new ILoadGameStateResponseListener() {
                    @Override
                    public void gsGameStateLoaded(byte[] gameState) {
                        if (Consts.isRead()) {
                            if (gameState != null) {

                                int i = 0;
                                for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

                                    byte[] load = new byte[4];

                                    load[0] = gameState[i];
                                    load[1] = gameState[i + 1];
                                    load[2] = gameState[i + 2];
                                    load[3] = gameState[i + 3];
                                    i += 4;
                                    Consts.getMap().put(integerEntry.getKey(), myGame.bytesToInt(load));
                                }

                                Consts.getBool().put(Consts.getSOUND(),
                                        gameState[Consts.getMap().size() * 4] == (byte) 1);
                                Consts.getBool().put(Consts.getVIBRATE(),
                                        gameState[Consts.getMap().size() * 4 + 1] == (byte) 1);
                                myGame.changeMusicPlay();

                            } else {
                                Gdx.app.log("Loading", "gameState is null");
                                myGame.initPref();
                            }

                            Consts.setRead(false);
                            myGame.setScreen(new Prosak(myGame));
                        }
                    }
                });

            } catch (UnsupportedOperationException unsupportedOperationException) {

                unsupportedOperationException.printStackTrace();
                myGame.initPref();
                Consts.setRead(false);
                myGame.setScreen(new Start(myGame));
            }

        } else if (!myGame.gsClient.isConnectionPending()) {
            Gdx.app.log("Loading screen", "problem with connect");
            myGame.initPref();
            myGame.setScreen(new Start(myGame));
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

    }
}
