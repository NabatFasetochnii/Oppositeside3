package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nabat.game.levels.Levels;
import com.nabat.game.levels.LoadingScreen;
import de.golfgl.gdxgamesvcs.IGameServiceClient;
import de.golfgl.gdxgamesvcs.IGameServiceListener;

import java.util.Map;

public class MyGame extends com.badlogic.gdx.Game implements IGameServiceListener { //TODO реализовать логгер

    private final String GAME_TAG = "MY_GAME";
    public IGameServiceClient gsClient;
    private Levels levels;
    private SpriteBatch batch;
    private Preferences preferences;
    private Music music;
//    public static final String EVENT1 = "EVENT1";
//    public static final String REPOLINK = "https://github.com/MrStahlfelge/gdx-gamesvcs";
//    public static final String FILE_ID = "cloud";

    @Override
    public void create() {

        Consts.setRead(true);

        music = Gdx.audio.newMusic(Gdx.files.internal(Consts.getPathToMusic()));
        music.setVolume(0.3f);
        music.setLooping(true);

        preferences = Gdx.app.getPreferences(Consts.getPrefName());

        Consts.loadFonts();
        Consts.loadMap();
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

        if (Consts.isSound()) {
            music.play();
        }
        //setScreen(new Start(this));

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
            Consts.setSound(preferences.getBoolean(Consts.getSOUND()));
            Consts.setVibrate(preferences.getBoolean(Consts.getVIBRATE()));
        }

    }

    public void changeSoundPlay() {

        if (Consts.isSound()) {
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
    }

    private void savePref() {

        for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

            preferences.putInteger(integerEntry.getKey(), integerEntry.getValue());

        }

        //
        preferences.putBoolean(Consts.getSOUND(), Consts.isSound());
        preferences.putBoolean(Consts.getVIBRATE(), Consts.isVibrate());

        preferences.flush();
    }

    private void saveDataToCloud() {

        if (gsClient.isSessionActive()) {

            try {

                byte[] save = new byte[Consts.getMap().size() * 4 + 2];

                int i = 0;
                for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

                    byte[] buf = intToByteArray(integerEntry.getValue());

                    save[i] = buf[0];
                    save[i + 1] = buf[1];
                    save[i + 2] = buf[2];
                    save[i + 3] = buf[3];
                    i += 4;
                }

                save[Consts.getMap().size() * 4] = (byte) (Consts.isSound() ? 1 : 0);
                save[Consts.getMap().size() * 4 + 1] = (byte) (Consts.isVibrate() ? 1 : 0);

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
