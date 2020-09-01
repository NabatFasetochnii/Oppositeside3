package com.nabat.game;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.pay.android.googlebilling.PurchaseManagerGoogleBilling;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import de.golfgl.gdxgamesvcs.GpgsClient;
import de.golfgl.gdxgamesvcs.IGameServiceIdMapper;

public class AndroidLauncher extends AndroidApplication implements AdsController {

    //    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-8832576459433269/9861516377";
    private static final String TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    GpgsClient gpgsClient;
    //    private AdView adView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        gpgsLoad();
        setBillingClient();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(TEST_BANNER_AD_UNIT_ID);
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                super.onAdClosed();
                onResume();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                onPause();

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });

        MyGame myGame = new MyGame(this);
        myGame.gsClient = gpgsClient;
        myGame.purchaseManager = new PurchaseManagerGoogleBilling(this);
        initialize(myGame, config);
    }

    private void gpgsLoad() {
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
    }

    private void setBillingClient() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    public void showBannerAd() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Gdx.app.log("android launcher", "The interstitial wasn't loaded yet.");
                }

            }
        });
    }

    @Override
    public void loadBanner() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });
    }
}


