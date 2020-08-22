package com.nabat.game;

import com.badlogic.gdx.Screen;

public class Prosak implements Screen {

    MyGame myGame;

    public Prosak(MyGame myGame) {

        this.myGame = myGame;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Consts.clear();
        myGame.setScreen(new Start(myGame));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
