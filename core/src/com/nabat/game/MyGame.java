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

    public static final String LEADERBOARD1 = "BOARD1";
    public static final String ACHIEVEMENT1 = "ACH1";
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

            if (gsClient.isConnectionPending()) {

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


            /*Consts.setCountOfAllPoints(preferences.getInteger(Consts.getCOUNT0()));//сохранение прогресса
            //
            Consts.setCountOfPoints1(preferences.getInteger(Consts.getCOUNT1()));
            Consts.setCountOfPoints2(preferences.getInteger(Consts.getCOUNT2()));
            Consts.setCountOfPoints3(preferences.getInteger(Consts.getCOUNT3()));
            Consts.setCountOfPoints4(preferences.getInteger(Consts.getCOUNT4()));
            //
            Consts.setCountOfPoints11(preferences.getInteger(Consts.getCOUNT11()));
            Consts.setCountOfPoints21(preferences.getInteger(Consts.getCOUNT21()));
            Consts.setCountOfPoints31(preferences.getInteger(Consts.getCOUNT31()));
            Consts.setCountOfPoints41(preferences.getInteger(Consts.getCOUNT41()));
            //
            Consts.setCountOfPoints111(preferences.getInteger(Consts.getCOUNT111()));
            Consts.setCountOfPoints211(preferences.getInteger(Consts.getCOUNT211()));
            Consts.setCountOfPoints311(preferences.getInteger(Consts.getCOUNT311()));
            Consts.setCountOfPoints411(preferences.getInteger(Consts.getCOUNT411()));
            //
            Consts.setCountOfPoints12(preferences.getInteger(Consts.getCOUNT12()));
            Consts.setCountOfPoints22(preferences.getInteger(Consts.getCOUNT22()));
            Consts.setCountOfPoints32(preferences.getInteger(Consts.getCOUNT32()));
            Consts.setCountOfPoints42(preferences.getInteger(Consts.getCOUNT42()));
            //
            Consts.setCountOfPoints121(preferences.getInteger(Consts.getCOUNT121()));
            Consts.setCountOfPoints221(preferences.getInteger(Consts.getCOUNT221()));
            Consts.setCountOfPoints321(preferences.getInteger(Consts.getCOUNT321()));
            Consts.setCountOfPoints421(preferences.getInteger(Consts.getCOUNT421()));
            //
            Consts.setCountOfPoints122(preferences.getInteger(Consts.getCOUNT122()));
            Consts.setCountOfPoints222(preferences.getInteger(Consts.getCOUNT222()));
            Consts.setCountOfPoints322(preferences.getInteger(Consts.getCOUNT322()));
            Consts.setCountOfPoints422(preferences.getInteger(Consts.getCOUNT422()));
            //
            Consts.setCountOfPoints1R(preferences.getInteger(Consts.getCOUNT1R()));
            Consts.setCountOfPoints2R(preferences.getInteger(Consts.getCOUNT2R()));
            Consts.setCountOfPoints3R(preferences.getInteger(Consts.getCOUNT3R()));
            Consts.setCountOfPoints4R(preferences.getInteger(Consts.getCOUNT4R()));
            //
            Consts.setCountOfPoints1R(preferences.getInteger(Consts.getCOUNT1R1()));
            Consts.setCountOfPoints2R(preferences.getInteger(Consts.getCOUNT2R1()));
            Consts.setCountOfPoints3R(preferences.getInteger(Consts.getCOUNT3R1()));
            Consts.setCountOfPoints4R(preferences.getInteger(Consts.getCOUNT4R1()));
            //
            Consts.setCountOfPoints1R(preferences.getInteger(Consts.getCOUNT1R2()));
            Consts.setCountOfPoints2R(preferences.getInteger(Consts.getCOUNT2R2()));
            Consts.setCountOfPoints3R(preferences.getInteger(Consts.getCOUNT3R2()));
            Consts.setCountOfPoints4R(preferences.getInteger(Consts.getCOUNT4R2()));*/
            //
            Consts.setSound(preferences.getBoolean(Consts.getSOUND()));
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
        Consts.clear();
        super.render();
    }

    private void savePref() {

        for (Map.Entry<String, Integer> integerEntry : Consts.getMap().entrySet()) {

            preferences.putInteger(integerEntry.getKey(), integerEntry.getValue());
        }

        /*preferences.putInteger(Consts.getCOUNT0(), Consts.getCountOfAllPoints());
        //
        preferences.putInteger(Consts.getCOUNT1(), Consts.getCountOfPoints1());
        preferences.putInteger(Consts.getCOUNT2(), Consts.getCountOfPoints2());
        preferences.putInteger(Consts.getCOUNT3(), Consts.getCountOfPoints3());
        preferences.putInteger(Consts.getCOUNT4(), Consts.getCountOfPoints4());
        //
        preferences.putInteger(Consts.getCOUNT11(), Consts.getCountOfPoints11());
        preferences.putInteger(Consts.getCOUNT21(), Consts.getCountOfPoints21());
        preferences.putInteger(Consts.getCOUNT31(), Consts.getCountOfPoints31());
        preferences.putInteger(Consts.getCOUNT41(), Consts.getCountOfPoints41());
        //
        preferences.putInteger(Consts.getCOUNT111(), Consts.getCountOfPoints111());
        preferences.putInteger(Consts.getCOUNT211(), Consts.getCountOfPoints211());
        preferences.putInteger(Consts.getCOUNT311(), Consts.getCountOfPoints311());
        preferences.putInteger(Consts.getCOUNT411(), Consts.getCountOfPoints411());
        //
        preferences.putInteger(Consts.getCOUNT12(), Consts.getCountOfPoints12());
        preferences.putInteger(Consts.getCOUNT22(), Consts.getCountOfPoints22());
        preferences.putInteger(Consts.getCOUNT32(), Consts.getCountOfPoints32());
        preferences.putInteger(Consts.getCOUNT42(), Consts.getCountOfPoints42());
        //
        preferences.putInteger(Consts.getCOUNT121(), Consts.getCountOfPoints121());
        preferences.putInteger(Consts.getCOUNT221(), Consts.getCountOfPoints221());
        preferences.putInteger(Consts.getCOUNT321(), Consts.getCountOfPoints321());
        preferences.putInteger(Consts.getCOUNT421(), Consts.getCountOfPoints421());
        //
        preferences.putInteger(Consts.getCOUNT122(), Consts.getCountOfPoints122());
        preferences.putInteger(Consts.getCOUNT222(), Consts.getCountOfPoints222());
        preferences.putInteger(Consts.getCOUNT322(), Consts.getCountOfPoints322());
        preferences.putInteger(Consts.getCOUNT422(), Consts.getCountOfPoints422());
        //
        preferences.putInteger(Consts.getCOUNT1R(), Consts.getCountOfPoints1R());
        preferences.putInteger(Consts.getCOUNT2R(), Consts.getCountOfPoints2R());
        preferences.putInteger(Consts.getCOUNT3R(), Consts.getCountOfPoints3R());
        preferences.putInteger(Consts.getCOUNT4R(), Consts.getCountOfPoints4R());
        //
        preferences.putInteger(Consts.getCOUNT1R(), Consts.getCountOfPoints1R1());
        preferences.putInteger(Consts.getCOUNT2R(), Consts.getCountOfPoints2R1());
        preferences.putInteger(Consts.getCOUNT3R(), Consts.getCountOfPoints3R1());
        preferences.putInteger(Consts.getCOUNT4R(), Consts.getCountOfPoints4R1());
        //
        preferences.putInteger(Consts.getCOUNT1R(), Consts.getCountOfPoints1R2());
        preferences.putInteger(Consts.getCOUNT2R(), Consts.getCountOfPoints2R2());
        preferences.putInteger(Consts.getCOUNT3R(), Consts.getCountOfPoints3R2());
        preferences.putInteger(Consts.getCOUNT4R(), Consts.getCountOfPoints4R2());*/
        //
        preferences.putBoolean(Consts.getSOUND(), Consts.isSound());

        preferences.flush();
    }

    private void saveDataToCloud() {

        if (gsClient.isSessionActive()) {

            try {

                byte[] save = new byte[Consts.getMap().size() * 4 + 1];

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
