package com.nabat.game.inputs;

import com.badlogic.gdx.InputProcessor;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.levels.AchievementsScreen;
import com.nabat.game.levels.LeaderBoardScreen;
import com.nabat.game.levels.Start;

public class InputForScroll implements InputProcessor {

    private final MyGame myGame;
    private final int rectS;
    private int y;
    private int height;
    private AchievementsScreen achievementsScreen;
    private LeaderBoardScreen leaderBoardScreen;
    private int scroll;

    public InputForScroll(MyGame myGame, int rectS, int height, AchievementsScreen achievementsScreen) {

        this.myGame = myGame;
        this.rectS = rectS;
        this.height = height;
        this.achievementsScreen = achievementsScreen;
    }

    public InputForScroll(MyGame myGame, int rectS, int height, LeaderBoardScreen leaderBoardScreen) {

        this.myGame = myGame;
        this.rectS = rectS;
        this.height = height;
        this.leaderBoardScreen = leaderBoardScreen;

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        y = screenY;

        if (Consts.isTouch(Consts.getWIDTH() - rectS, Consts.getHEIGHT() - rectS, rectS, rectS,
                screenX, Consts.getHEIGHT() - y)) {
            myGame.setScreen(new Start(myGame));
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        int dy = y - screenY;

        if (achievementsScreen != null) {
            scroll = (achievementsScreen.getScroll() - dy) / 2;
            achievementsScreen.setScroll(scroll);
        }

        if (leaderBoardScreen != null) {
            scroll = (leaderBoardScreen.getScroll() - dy) / 2;
            leaderBoardScreen.setScroll(scroll);
        }
        y = screenY;

        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
