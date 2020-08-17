package com.nabat.game;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import de.golfgl.gdxgamesvcs.GpgsClient;

public class AndroidLauncher extends AndroidApplication {


    GpgsClient gpgsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;

        gpgsClient = new GpgsClient().initialize(this, false);
        MyGame myGame = new MyGame();
        myGame.gsClient = gpgsClient;

        initialize(myGame, config);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (gpgsClient != null)
            gpgsClient.onGpgsActivityResult(requestCode, resultCode, data);
    }

}


