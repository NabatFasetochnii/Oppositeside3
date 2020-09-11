package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Loader {

    private final TextureAtlas textureAtlas;
    private TextureRegion exitButton;
    private TextureRegion soundOn;
    private TextureRegion soundOff;
    private TextureRegion shopButton;
    private TextureRegion settingsButton;
    //    private static TextureRegion rateButton;
    private TextureRegion vibrateButton;
    private TextureRegion noVibrateButton;
    private TextureRegion leaderBoardButton;
    private TextureRegion achievementsButton;
    private TextureRegion loadIcon;
    private TextureRegion winIcon;
    private BitmapFont fontForLose;
    private BitmapFont fontForCount;
    private BitmapFont fontForCountMiss;
    private BitmapFont fontForWin;
    private BitmapFont fontForMenu;
    private BitmapFont fontForStore;


    Loader() {

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
        loadWinIcon();
        loadFonts();

    }

    public void loadFonts() {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Consts.getWIDTH() / 7.5f);
        parameter.color = Color.RED;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = Consts.getWIDTH() / 216f;
        fontForLose = generator.generateFont(parameter);

        parameter.color = Color.GREEN;

        fontForWin = generator.generateFont(parameter);

        parameter.size = (int) (Consts.getWIDTH() / 10f);
        parameter.borderWidth = Consts.getWIDTH() / 360f;
        fontForCount = generator.generateFont(parameter);

        parameter.color = Color.RED;

        fontForCountMiss = generator.generateFont(parameter);

        parameter.size = Consts.getWIDTH() / 12;
        parameter.color = Color.CHARTREUSE;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = Consts.getWIDTH() / 216f;
        fontForMenu = generator.generateFont(parameter);

        parameter.size = Consts.getWIDTH() / 16;
        fontForStore = generator.generateFont(parameter);
        generator.dispose();
    }

    public BitmapFont getFontForLose() {
        return fontForLose;
    }

    public BitmapFont getFontForCount() {
        return fontForCount;
    }

    public BitmapFont getFontForCountMiss() {
        return fontForCountMiss;
    }

    public BitmapFont getFontForWin() {
        return fontForWin;
    }

    public BitmapFont getFontForMenu() {
        return fontForMenu;
    }

    public BitmapFont getFontForStore() {
        return fontForStore;
    }

    private void loadWinIcon() {

        winIcon = textureAtlas.findRegion("ic_done_outline");
//        winIcon.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadIcon() {

        loadIcon = textureAtlas.findRegion("icon2");
//        loadIcon.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadSoundOn() {
        soundOn = textureAtlas.findRegion("ic_action_music_note");
//        soundOn.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadSoundOff() {
        soundOff = textureAtlas.findRegion("ic_action_music_off");
//        soundOff.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadExit() {

        exitButton = textureAtlas.findRegion("ic_clear");
//        exitButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadShop() {

        shopButton = textureAtlas.findRegion("ic_shopping_cart");
//        shopButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

//    private static void loadRate() {
//        rateButton = textureAtlas.findRegion("ic_thumb_up");
//        rateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//    }

    private void loadSettings() {

        settingsButton = textureAtlas.findRegion("ic_settings");
//        settingsButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadAch() {

        achievementsButton = textureAtlas.findRegion("achievement3");
//        achievementsButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadLeaderBoard() {

        leaderBoardButton = textureAtlas.findRegion("icons8-leaderboard-100-2");
//        leaderBoardButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    private void loadVibrate() {

        vibrateButton = textureAtlas.findRegion("ic_action_vibration");
        noVibrateButton = textureAtlas.findRegion("ic_action_no_vibration");

//        vibrateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        noVibrateButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public TextureRegion getLoadIcon() {
        return loadIcon;
    }

    public TextureRegion getLeaderBoardButton() {
        return leaderBoardButton;
    }

    public TextureRegion getAchievementsButton() {
        return achievementsButton;
    }

    public TextureRegion getVibrateButton() {
        return vibrateButton;
    }

    public TextureRegion getNoVibrateButton() {
        return noVibrateButton;
    }

    public TextureRegion getExitButton() {

        return exitButton;
    }

    public TextureRegion getWinIcon() {
        return winIcon;
    }

    public TextureRegion getSettingsButton() {
        return settingsButton;
    }

//    public static TextureRegion getRateButton() {
//        return rateButton;
//    }

    public TextureRegion getSoundOn() {
        return soundOn;
    }

    public TextureRegion getSoundOff() {
        return soundOff;
    }

    public void dispose() {
        fontForCount.dispose();
        fontForCountMiss.dispose();
        fontForLose.dispose();
        fontForWin.dispose();
        fontForStore.dispose();
        textureAtlas.dispose();
    }

    public TextureRegion getShopButton() {
        return shopButton;
    }
}
