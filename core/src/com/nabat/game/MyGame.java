package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nabat.game.levels.Levels;
import com.nabat.game.levels.LoadingScreen;
import com.nabat.game.levels.Start;
import de.golfgl.gdxgamesvcs.IGameServiceClient;
import de.golfgl.gdxgamesvcs.IGameServiceListener;

import java.util.Map;

public class MyGame extends com.badlogic.gdx.Game implements IGameServiceListener { //TODO реализовать логгер

    private final String GAME_TAG = "MY_GAME";
    private final AdsController adsController;
    //    private final String SKU = "98s252md49mjtivhx8sz";
    public IGameServiceClient gsClient;
    //    public PurchaseManager purchaseManager;
    private Levels levels;
    private SpriteBatch batch;
    private Preferences preferences;
    private Music music;

    public MyGame(AdsController adsController) {

        this.adsController = adsController;
    }

    @Override
    public void create() {

        Consts.setRead(true);
        music = Gdx.audio.newMusic(Gdx.files.internal(Consts.getPathToMusic()));
        music.setVolume(0.3f);
        music.setLooping(true);

/*        PurchaseManagerConfig pmc = new PurchaseManagerConfig();
        pmc.addOffer(new Offer().setType(OfferType.SUBSCRIPTION).setIdentifier(SKU));
//        pmc.addStoreParam(PurchaseManagerConfig.STORE_NAME_ANDROID_GOOGLE, null);

        purchaseManager.install(new MyObserver(this), pmc, true);*/

        preferences = Gdx.app.getPreferences(Consts.getPrefName());

        Consts.loadFonts();
        Consts.loadMaps();
        batch = new SpriteBatch();
        levels = new Levels(this);
        Loader.load();

        // for getting callbacks from the client
        gsClient.setListener(this);
        // establish a connection to the game service without error messages or login screens
        gsClient.resumeSession();

        if (Consts.isLastSessionFall()) {

            initPref();
        } else {

            if (gsClient.isConnectionPending() || gsClient.isSessionActive()) {

                setScreen(new LoadingScreen(this));
            } else {
                Gdx.app.log(GAME_TAG, "isConnectionPending() - false");
                initPref();
                setScreen(new Start(this));
            }
        }
        adsController.showBannerForStart();
//        gsClient.incrementAchievement()

    }

    public int bytesToInt(byte[] gameState) {
        return ((gameState[0] & 0xff) << 24) | ((gameState[1] & 0xff) << 16) |
                ((gameState[2] & 0xff) << 8) | (gameState[3] & 0xff);
    }

    public byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value};
    }

    public void initPref() {

        if (preferences.contains(Consts.getCOUNT0())) {

            for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

                Consts.getMap().put(integerEntry.getKey(), preferences.getInteger(integerEntry.getKey()));
            }

            for (Map.Entry<String, Boolean> integerEntry : Consts.getBool().entrySet()) {

                Consts.getBool().put(integerEntry.getKey(), preferences.getBoolean(integerEntry.getKey()));
            }
        }
        changeMusicPlay();

    }

    public void changeMusicPlay() {

        if (Consts.getBool().get(Consts.getSOUND())) {
            music.play();
        } else {
            music.pause();
        }
    }

    @Override
    public void pause() {
        super.pause();

        gsClient.pauseSession();
    }

    @Override
    public void resume() {
        super.resume();

        gsClient.resumeSession();
    }


    @Override
    public void render() {
//        Consts.clear();
        super.render();

        Consts.time += Gdx.graphics.getDeltaTime();
        if (Consts.time >= 3600) {
            gsClient.unlockAchievement(Consts.getTakeThought());
        }
        Consts.timeSpeed += Gdx.graphics.getDeltaTime();
    }

    private void savePref() {

        preferences.put(Consts.getMap());
        preferences.put(Consts.getBool());

        preferences.flush();
    }

    private void saveDataToCloud() {

        if (gsClient.isSessionActive()) {
///data/user/0/com.nabat.game/shared_prefs/fileForPrefs.xml.bak
            try {

                byte[] save = new byte[Consts.getMap().size() * 4 + 3];

                int i = 0;
                for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

                    byte[] buf = intToByteArray(integerEntry.getValue());

                    save[i] = buf[0];
                    save[i + 1] = buf[1];
                    save[i + 2] = buf[2];
                    save[i + 3] = buf[3];
                    i += 4;
                }

                save[Consts.getMap().size() * 4] = (byte) (Consts.getBool().get(Consts.getSOUND()) ? 1 : 0);
                save[Consts.getMap().size() * 4 + 1] = (byte) (Consts.getBool().get(Consts.getVIBRATE()) ? 1 : 0);
                save[Consts.getMap().size() * 4 + 2] = (byte) (Consts.getBool().get(Consts.getIsFirst()) ? 1 : 0);

                gsClient.saveGameState(Consts.getPrefName(),
                        save, 0, null);

                Consts.setLastSessionFall(false);
            } catch (UnsupportedOperationException unsupportedOperationException) {

                Gdx.app.log(GAME_TAG, "unsupportedOperationException save");
                Consts.setLastSessionFall(true);

            }
        } else {
            Gdx.app.log(GAME_TAG, "save only in storage");
            Consts.setLastSessionFall(true);
        }
    }

    public void updatePref() {

        savePref();
        saveDataToCloud();
    }

    public Levels getLevels() {
        return levels;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void dispose() {

        updatePref();
        Consts.dispose();
        music.dispose();
        //l0.dispose();
        levels.dispose();
        Loader.dispose();
//        purchaseManager.dispose();
    }


    public AdsController getAdsController() {
        return adsController;
    }

    @Override
    public void gsOnSessionActive() {

    }

    @Override
    public void gsOnSessionInactive() {

    }

    @Override
    public void gsShowErrorToUser(GsErrorType et, String msg, Throwable t) {

    }
}
