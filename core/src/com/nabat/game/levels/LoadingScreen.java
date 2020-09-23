package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import de.golfgl.gdxgamesvcs.gamestate.ILoadGameStateResponseListener;

import java.util.Map;

public class LoadingScreen implements Screen {

    private final MyGame myGame;
    private final float size = Consts.getWIDTH() / 2f;

    public LoadingScreen(MyGame myGame) {

        this.myGame = myGame;
    }

    @Override
    public void show() {
        /*Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
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
        });*/
    }

    @Override
    public void render(float delta) {
        Consts.clear();

        Consts.time += Gdx.graphics.getDeltaTime();
        if (Consts.time >= 3600) {
            myGame.gsClient.unlockAchievement(Consts.getTakeThought());
        }
        Consts.timeSpeed += Gdx.graphics.getDeltaTime();

        myGame.getBatch().begin();

        myGame.getBatch().draw(myGame.loader.getLoadIcon(),//TODO МБ ПОТОМ СДЕЛАЮ ГИФ ОЧ КУ
                Consts.getWIDTH() / 2f - size / 2f,
                Consts.getHEIGHT() / 2f - size / 2f, size, size);

        myGame.getBatch().end();

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

                                int y = 0;
                                for (Map.Entry<Integer, Boolean> integerEntry : Consts.getIsWin().entrySet()) {

                                    Consts.getIsWin().put(integerEntry.getKey(),
                                            gameState[Consts.getMap().size() * 4 + y] == (byte) 1);
                                    y++;
                                }

                                Consts.getBool().put(Consts.getSOUND(),
                                        gameState[Consts.getMap().size() * 4 + y] == (byte) 1);
                                Consts.getBool().put(Consts.getVIBRATE(),
                                        gameState[Consts.getMap().size() * 4 + y + 1] == (byte) 1);
                                Consts.getBool().put(Consts.getIsFirst(),
                                        gameState[Consts.getMap().size() * 4 + y + 2] == (byte) 1);
                                myGame.changeMusicPlay();

                                Gdx.app.log("Loading", "loaded from cloud");
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
