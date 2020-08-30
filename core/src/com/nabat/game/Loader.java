package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Loader {

    private static TextureRegion exitButton;
    private static TextureRegion soundOn;
    private static TextureRegion soundOff;
    private static TextureRegion shopButton;
    private static TextureRegion settingsButton;
    //    private static TextureRegion rateButton;
    private static TextureRegion vibrateButton;
    private static TextureRegion noVibrateButton;
    private static TextureRegion leaderBoardButton;
    private static TextureRegion achievementsButton;
    private static TextureRegion loadIcon;
    private static TextureAtlas textureAtlas;

    Loader() {


    }

    public static TextureRegion getLoadIcon() {
        return loadIcon;
    }

    public static TextureRegion getLeaderBoardButton() {
        return leaderBoardButton;
    }

    public static TextureRegion getAchievementsButton() {
        return achievementsButton;
    }

    public static TextureRegion getVibrateButton() {
        return vibrateButton;
    }

    public static TextureRegion getNoVibrateButton() {
        return noVibrateButton;
    }

    public static TextureRegion getExitButton() {

        return exitButton;
    }

    public static TextureRegion getSettingsButton() {
        return settingsButton;
    }

//    public static TextureRegion getRateButton() {
//        return rateButton;
//    }

    public static TextureRegion getSoundOn() {
        return soundOn;
    }

    public static TextureRegion getSoundOff() {
        return soundOff;
    }

    public static void dispose() {

        textureAtlas.dispose();
    }

    public static TextureRegion getShopButton() {
        return shopButton;
    }

    public static void load() {

        textureAtlas = new TextureAtlas(
                Gdx.files.internal("texture//assets.atlas"));//texture\assets.atlas

        loadExit();
        loadShop();
        loadSettings();
        loadSoundOn();
        loadSoundOff();
//        loadRate();
        loadVibrate();
        loadAch();
        loadLeaderBoard();
        loadIcon();
    }

    private static void loadIcon() {

        loadIcon = textureAtlas.findRegion("icon2");
        loadIcon.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadSoundOn() {
        soundOn = textureAtlas.findRegion("ic_action_music_note");
        soundOn.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadSoundOff() {
        soundOff = textureAtlas.findRegion("ic_action_music_off");
        soundOff.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadExit() {

        exitButton = textureAtlas.findRegion("ic_clear");
        exitButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadShop() {

        shopButton = textureAtlas.findRegion("ic_shopping_cart");
        shopButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

//    private static void loadRate() {
//        rateButton = textureAtlas.findRegion("ic_thumb_up");
//        rateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//    }

    private static void loadSettings() {

        settingsButton = textureAtlas.findRegion("ic_settings");
        settingsButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadAch() {

        achievementsButton = textureAtlas.findRegion("achievement3");
        achievementsButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadLeaderBoard() {

        leaderBoardButton = textureAtlas.findRegion("icons8-leaderboard-100-2");
        leaderBoardButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private static void loadVibrate() {

        vibrateButton = textureAtlas.findRegion("ic_action_vibration");
        noVibrateButton = textureAtlas.findRegion("ic_action_no_vibration");

        vibrateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        noVibrateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
}
