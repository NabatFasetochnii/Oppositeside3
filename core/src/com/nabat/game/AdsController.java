package com.nabat.game;

public interface AdsController {
    void showBannerAd();

    boolean isEnabled();

    void loadBanner();

    void hideBannerForStart();

    void showBannerForStart();
}
