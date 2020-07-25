package com.nabat.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.nabat.game.levels.Lvl1;

public class Game extends ApplicationAdapter {

    RectZone l1, l2, l3, l0;
    boolean startScreen = true;
    Lvl1 lvl1;
    //SpriteBatch spriteBatch;
    final int LEVEL_LEVEL = 200;

    @Override
    public void create() {

        lvl1 = new Lvl1(Color.BLACK);

        l0 = new RectZone(0, Gdx.app.getGraphics().getHeight() / 2,
                Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight(), Color.BLACK);

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
        //spriteBatch = new SpriteBatch();

        lvl1.load();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (startScreen) {

//            spriteBatch.begin();
            l0.draw();

//            spriteBatch.end();

            if (Gdx.input.isTouched()) {

                if (l0.isTouch(Gdx.input.getX(), Gdx.input.getY())) {

                    startScreen = false;
                }
            }
        }else {
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
