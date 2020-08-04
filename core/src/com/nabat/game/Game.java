package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nabat.game.levels.Levels;

public class Game extends com.badlogic.gdx.Game { //TODO реализовать логгер

    Levels levels;
    //private RectZone l0;
    //private final boolean startScreen = true;
    //private BitmapFont font;
    private SpriteBatch batch;
    private Preferences preferences;

    @Override
    public void create() {

        preferences = Gdx.app.getPreferences(Consts.getPrefName());

        Consts.setCountOfAllPoints(preferences.getInteger(Consts.getCOUNT0()));
        Consts.setCountOfPoints1(preferences.getInteger(Consts.getCOUNT1()));
        Consts.setCountOfPoints2(preferences.getInteger(Consts.getCOUNT2()));
        Consts.setCountOfPoints3(preferences.getInteger(Consts.getCOUNT3()));
        Consts.setCountOfPoints4(preferences.getInteger(Consts.getCOUNT4()));
        batch = new SpriteBatch();
       /* FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        float PLAY_SCREEN = 7.5f;
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / PLAY_SCREEN);
        parameter.color = Color.YELLOW;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        //font = generator.generateFont(parameter);
        generator.dispose();*/
        levels = new Levels(this);

        //levelFactory = levels.getLvl1();

//        l0 = new RectZone((int) (-Consts.getWIDTH() * 0.2f), Consts.getHEIGHT() / 2,
//                (int) (Consts.getWIDTH() * 1.3f), Consts.getHEIGHT(), Color.RED);
//        l0.setPulsar(false);

        Loader.load();

        setScreen(levels);
    }


    @Override
    public void render() {

        super.render();
        /*Gdx.gl.glClearColor(255, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (startScreen) {

            l0.draw();
            batch.begin();
            font.draw(batch, Consts.getPLAY(),
                    Gdx.app.getGraphics().getWidth() / 7.5f,
                    Gdx.app.getGraphics().getHeight() * 0.75f);
            batch.end();

            if (Gdx.input.isTouched()) {

                if (l0.isTouch(Gdx.input.getX(), Gdx.app.getGraphics().getHeight() - Gdx.input.getY())) {

                    startScreen = false;
                }
            }
        } else {
            setScreen(levelFactory);
            super.render();
        }
*/
    }

    public void updatePref() {

        preferences.putInteger(Consts.getCOUNT0(), Consts.getCountOfAllPoints());
        preferences.putInteger(Consts.getCOUNT1(), Consts.getCountOfPoints1());
        preferences.putInteger(Consts.getCOUNT2(), Consts.getCountOfPoints2());
        preferences.putInteger(Consts.getCOUNT3(), Consts.getCountOfPoints3());
        preferences.putInteger(Consts.getCOUNT4(), Consts.getCountOfPoints4());
        preferences.flush();
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


        //l0.dispose();
        levels.dispose();
        Loader.dispose();
    }
}
