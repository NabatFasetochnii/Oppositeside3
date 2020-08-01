package com.nabat.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nabat.game.levels.LevelFactory;
import com.nabat.game.levels.Levels;

public class Game extends com.badlogic.gdx.Game { //TODO реализовать логгер

    Levels levels;
    //private RectZone l0;
    //private final boolean startScreen = true;
    private LevelFactory levelFactory;
    //private BitmapFont font;
    private SpriteBatch batch;

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void create() {

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

        levelFactory = levels.getLvl1();

//        l0 = new RectZone((int) (-Consts.getWIDTH() * 0.2f), Consts.getHEIGHT() / 2,
//                (int) (Consts.getWIDTH() * 1.3f), Consts.getHEIGHT(), Color.RED);
//        l0.setPulsar(false);

        Loader.load();

        setScreen(levelFactory);
    }


    @Override
    public void render() {

        super.render();
        /*Gdx.gl.glClearColor(255, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (startScreen) { //TODO переделать всю логику под setScreen, наверное это будет не сложно

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


    public Levels getLevels() {
        return levels;
    }


    @Override
    public void dispose() {
        //l0.dispose();
        levels.dispose();
        levelFactory.dispose();
        Loader.dispose();
    }
}
