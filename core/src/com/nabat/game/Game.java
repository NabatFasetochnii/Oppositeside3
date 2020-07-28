package com.nabat.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.nabat.game.levels.Lvl1;

public class Game extends ApplicationAdapter {

    private final int LEVEL_LEVEL = 200;
    private final float PLAY_SCREEN = 7.5f;
    private RectZone l1, l2, l3, l0;
    private boolean startScreen = true;
    private Lvl1 lvl1;
    private Input input;
    private BitmapFont font;
    private SpriteBatch batch;

    @Override
    public void create() {

        batch = new SpriteBatch();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / PLAY_SCREEN);
        parameter.color = Color.YELLOW;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        font = generator.generateFont(parameter);
        generator.dispose();

        lvl1 = new Lvl1(Color.RED);

        l0 = new RectZone(0, Gdx.app.getGraphics().getHeight() / 2,
                Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight(), Color.RED);

        l1 = new RectZone(100,
                Gdx.app.getGraphics().getHeight() - LEVEL_LEVEL,
                100,
                100, Color.BLACK);

        l2 = new RectZone(300,
                Gdx.app.getGraphics().getHeight() - LEVEL_LEVEL,
                100,
                100, Color.RED);
        l3 = new RectZone(500,
                Gdx.app.getGraphics().getHeight() - LEVEL_LEVEL,
                100,
                100, Color.YELLOW);
        lvl1.load();

        input = new Input(lvl1);


    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(255, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (startScreen) {

            l0.draw();
            batch.begin();
            font.draw(batch, Consts.getPLAY(),
                    Gdx.app.getGraphics().getWidth() / 7.5f,
                    Gdx.app.getGraphics().getHeight()*0.75f);
            batch.end();

            if (Gdx.input.isTouched()) {

                if (l0.isTouch(Gdx.input.getX(), Gdx.app.getGraphics().getHeight() - Gdx.input.getY())) {

                    startScreen = false;
                }
            }
        } else {

            Gdx.input.setInputProcessor(input);

            lvl1.draw();

            //openMenu();
        }


    }

    private void openMenu() {

        l1.draw();
        l2.draw();
        l3.draw();

    }


    @Override
    public void dispose() {
        l0.dispose();
        l1.dispose();
        l2.dispose();
        l3.dispose();
        lvl1.dispose();
    }
}
