package com.nabat.game.inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.levels.LeaderBoardScreen;
import com.nabat.game.levels.Start;
import de.golfgl.gdxgamesvcs.GameServiceException;
import de.golfgl.gdxgamesvcs.IGameServiceClient;
import de.golfgl.gdxgamesvcs.leaderboard.IFetchLeaderBoardEntriesResponseListener;
import de.golfgl.gdxgamesvcs.leaderboard.ILeaderBoardEntry;

public class InputForStart implements InputProcessor {

    private final MyGame myGame;
    private final RectZone rectZone, gpgsZone;
    private final Start start;

    public InputForStart(Start start) {

        this.start = start;
        this.myGame = start.getMyGame();
        this.rectZone = start.getStartZone();
        gpgsZone = start.getGpgsZone();
    }

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

        int y = Consts.getHEIGHT() - screenY;

        if (rectZone.isTouch(screenX, y)) {

            myGame.setScreen(myGame.getLevels());
            start.dispose();
        }

        if (Consts.isTouch(start.getShopX(), start.getShopY(), start.getShopW(), start.getShopH(), screenX, y)) {

            //TODO SHOP
        }

        if (Consts.isTouch(start.getSoundX(), start.getSoundY(), start.getSoundW(), start.getSoundH(), screenX, y)) {
            Consts.getBool().put(Consts.getSOUND(), !Consts.getBool().get(Consts.getSOUND()));
//            Consts.setSound(!Consts.isSound());
            myGame.changeMusicPlay();
        }

        if (Consts.isTouch(start.getVibX(), start.getVibY(), start.getSoundW(), start.getSoundH(), screenX, y)) {

//            Consts.setVibrate(!Consts.isVibrate());
            Consts.getBool().put(Consts.getVIBRATE(), !Consts.getBool().get(Consts.getVIBRATE()));
        }

        if (gpgsZone.isTouch(screenX, y)) {


            if (myGame.gsClient.isSessionActive()) {
                myGame.gsClient.logOff();
            } else {
                if (!myGame.gsClient.logIn()) {
                    Gdx.app.error("GS_ERROR", "Cannot sign in: No credentials or session id given.");
                }
//                myGame.gsClient.refreshStatusLabel();

            }

//            Consts.setLogin(!Consts.isLogin());
        }

        /*if (Consts.isTouch(start.getRateX(), start.getRateY(), start.getShopW(), start.getShopH(), screenX, y)){

            //TODO ОЦЕНИТЕ ПРИЛОЖУХУ ПЖЖЖЖЖЖЖ
        }*/

        if (Consts.isTouch(start.getAchX(), start.getAchY(), start.getShopW(), start.getShopH(), screenX, y)) {

            start.setLoad(true);
            try {

                myGame.gsClient.showAchievements();
                start.setLoad(false);

            } catch (GameServiceException e) {
                e.printStackTrace();
                start.setLoad(false);
            }

            /*if (myGame.gsClient.isFeatureSupported(IGameServiceClient.GameServiceFeature.FetchAchievements)) {

                myGame.gsClient.fetchAchievements(new IFetchAchievementsResponseListener() {
                    @Override
                    public void onFetchAchievementsResponse(final Array<IAchievement> achievements) {
                        Gdx.app.postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                if (achievements != null) {
                                    if (achievements.size > 0) {
                                        start.setLoad(false);
                                        myGame.setScreen(new AchievementsScreen(myGame, achievements));
                                    }
                                }else {
                                    Gdx.input.vibrate(30);
                                    start.setLoad(false);
                                }
                            }
                        });
                    }
                });
            }else {
                Gdx.input.vibrate(30);
                start.setLoad(false);
            }*/
        }


        if (Consts.isTouch(start.getLeaderBX(), start.getLeaderBY(), start.getShopW(), start.getShopH(), screenX, y)) {

            start.setLoad(true);
            if (myGame.gsClient.isFeatureSupported(IGameServiceClient.GameServiceFeature.FetchLeaderBoardEntries)) {

                if (!myGame.gsClient.fetchLeaderboardEntries(Consts.getLEADERBOARD1(),
                        10, false,
                        new IFetchLeaderBoardEntriesResponseListener() {
                            @Override
                            public void onLeaderBoardResponse(final Array<ILeaderBoardEntry> leaderBoard) {
                                if (leaderBoard != null) {

                                    if (leaderBoard.size > 0) {

                                        Gdx.app.postRunnable(new Runnable() {
                                            @Override
                                            public void run() {
                                                start.setLoad(false);
                                                myGame.setScreen(new LeaderBoardScreen(myGame, leaderBoard));
                                            }
                                        });
                                    } else {
                                        Gdx.app.log("leaderB", "leaderBoard.size = 0");
                                        start.setLoad(false);
                                    }

                                } else {
                                    Gdx.input.vibrate(30);
                                    start.setLoad(false);
                                }

                            }
                        })) {
                    Gdx.app.log("inputForStart", "problem leaderBoard");
                    start.setLoad(false);
                }
            } else {
                Gdx.input.vibrate(30);
                start.setLoad(false);
            }
        }

        if (Consts.isTouch(start.getExitX(), start.getExitY(), start.getShopW(), start.getShopH(), screenX, y)) {

            myGame.updatePref();
            Consts.setRead(true);
            Gdx.app.exit();
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
}
