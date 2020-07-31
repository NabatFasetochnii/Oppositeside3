package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Loader {

    private static TextureRegion exitButton;
    private static TextureRegion shopButton;
    private static TextureRegion settingsButton;
    private static TextureAtlas textureAtlas;

    Loader() {


    }

    public static TextureRegion getExitButton() {
        return exitButton;
    }

    public static void setExitButton(TextureRegion exitButton) {
        Loader.exitButton = exitButton;
    }

    public static TextureRegion getShopButton() {
        return shopButton;
    }

    public static void setShopButton(TextureRegion shopButton) {
        Loader.shopButton = shopButton;
    }

    public static TextureRegion getSettingsButton() {
        return settingsButton;
    }

    public static void setSettingsButton(TextureRegion settingsButton) {
        Loader.settingsButton = settingsButton;
    }

    public static void load() {

        textureAtlas = new TextureAtlas(
                Gdx.files.internal("texture//assets.atlas"));//texture\assets.atlas
        loadExit();
        loadShop();
        loadSettings();
    }

    private static void loadExit() {

        exitButton = textureAtlas.findRegion("ic_clear");
    }

    private static void loadShop() {

        shopButton = textureAtlas.findRegion("ic_shopping_cart");
    }

    private static void loadSettings() {

        shopButton = textureAtlas.findRegion("ic_settings");
    }
}
