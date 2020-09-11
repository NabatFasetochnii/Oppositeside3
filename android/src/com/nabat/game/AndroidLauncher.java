package com.nabat.game;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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

    //        private static final String BANNER_AD_UNIT_ID = "ca-app-pub-8832576459433269/9861516377";
//        private static final String BANNER_START_AD_UNIT_ID = "ca-app-pub-8832576459433269/8336558007";
    private static final String TEST_BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    private static final String TEST_BANNER_AD_UNIT_ID2 = "ca-app-pub-3940256099942544/6300978111";
    GpgsClient gpgsClient;
    //    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private AdView adView;
    private MyGame myGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        gpgsLoad();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        setupAds();

        int zero;
//        zero = AdSize.BANNER.getHeight();
        zero = AdSize.SMART_BANNER.getHeightInPixels(this);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(TEST_BANNER_AD_UNIT_ID);
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                super.onAdClosed();
                onResume();

                showBannerForStart();
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

        myGame = new MyGame(this, zero);
        myGame.gsClient = gpgsClient;
        myGame.purchaseManager = new PurchaseManagerGoogleBilling(this);

        View gameView = initializeForView(myGame, config);

//        initialize(myGame, config);

        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layout.addView(adView, params);

        setContentView(layout);

    }

    public void setupAds() {
        adView = new AdView(this);
        adView.setVisibility(View.INVISIBLE);
        adView.setBackgroundColor(0xff000000); // black
        adView.setAdUnitId(TEST_BANNER_AD_UNIT_ID2);
        adView.setAdSize(AdSize.SMART_BANNER);
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
    public boolean isEnabled() {

        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network nw = null;
            if (connectivityManager != null) {
                nw = connectivityManager.getActiveNetwork();
            }
            if (nw == null) return false;
            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(nw);
            return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH));
        } else {
            NetworkInfo nwInfo = null;
            if (connectivityManager != null) {
                nwInfo = connectivityManager.getActiveNetworkInfo();
            }
            return nwInfo != null && nwInfo.isConnected();
        }

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

    @Override
    public void hideBannerForStart() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adView.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void showBannerForStart() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adView.setVisibility(View.VISIBLE);
                AdRequest.Builder builder = new AdRequest.Builder();
                AdRequest ad = builder.build();
                adView.loadAd(ad);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        myGame.updatePref();
    }
}