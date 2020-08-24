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


//        gpgsClient = new GpgsClient().initialize(this, true);

        this.gpgsClient = new GpgsClient()
                .setGpgsAchievementIdMapper(new IGameServiceIdMapper<String>() {
                    @Override
                    public String mapToGsId(String independantId) {
                        return GpgsMappers.mapToGpgsAchievement(independantId);
                    }
                }).setGpgsLeaderboardIdMapper(new IGameServiceIdMapper<String>() {
                    @Override
                    public String mapToGsId(String independantId) {
                        return GpgsMappers.mapToGpgsLeaderboard(independantId);
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


