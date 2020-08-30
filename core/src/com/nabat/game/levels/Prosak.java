package com.nabat.game.levels;

import com.badlogic.gdx.Screen;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;

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
