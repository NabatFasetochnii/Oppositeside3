package com.nabat.game;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import de.golfgl.gdxgamesvcs.GpgsClient;
import de.golfgl.gdxgamesvcs.IGameServiceIdMapper;

public class AndroidLauncher extends AndroidApplication {


    GpgsClient gpgsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;

        this.gpgsClient = new GpgsClient() {
            @Override
            public boolean submitEvent(String eventId, int increment) {
                return super.submitEvent(Consts.getEvents().get(eventId), increment);
            }
        }
                .setGpgsAchievementIdMapper(new IGameServiceIdMapper<String>() {
                    @Override
                    public String mapToGsId(String independantId) {
                        if (independantId != null) {
                            return Consts.getAchievements().get(independantId);
                        } else {
                            return null;
                        }

                    }
                }).setGpgsLeaderboardIdMapper(new IGameServiceIdMapper<String>() {
                    @Override
                    public String mapToGsId(String independantId) {
                        if (independantId != null) {
                            if (independantId.equals(Consts.getLEADERBOARD1())) {
                                return Consts.getLeaderBoard();
                            }
                        }
                        return null;
                    }
                }).initialize(this, true);

        MyGame myGame = new MyGame();
        myGame.gsClient = gpgsClient;

        initialize(myGame, config);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (gpgsClient != null)
            gpgsClient.onGpgsActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void finish() {
        super.finish();
        System.exit(0);
    }
}


