package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Array;
import com.nabat.game.Consts;
import com.nabat.game.Loader;
import com.nabat.game.MyGame;
import com.nabat.game.inputs.InputForScroll;
import de.golfgl.gdxgamesvcs.leaderboard.ILeaderBoardEntry;

public class LeaderBoardScreen implements Screen {

    private final MyGame myGame;
    private final Array<ILeaderBoardEntry> leaderBoard;
    private final int delta;
    private int height;
    private final int x;
    private final int rectS;
    private final GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForMenu(), Consts.getPLAY());
    private final InputForScroll inputForScroll;
    private int scroll;

    public LeaderBoardScreen(MyGame myGame, Array<ILeaderBoardEntry> leaderBoard) {

        this.myGame = myGame;
        this.leaderBoard = leaderBoard;
        delta = Consts.getWIDTH() / 100;
        rectS = Consts.getWIDTH() / 10;
        height = Consts.getHEIGHT() - rectS - delta;
        x = delta;
        inputForScroll = new InputForScroll(myGame, rectS, height, this);
    }

    public int getScroll() {
        return scroll;
    }

    public void setScroll(int scroll) {
        this.scroll = scroll;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputForScroll);
    }

    @Override
    public void render(float delta) {

        Consts.clear();

        height = inputForScroll.getHeight();
        myGame.getBatch().begin();

        myGame.getBatch().draw(Loader.getSettingsButton(), Consts.getWIDTH() - rectS, Consts.getHEIGHT() - rectS,
                rectS, rectS);

        for (ILeaderBoardEntry leader :
                leaderBoard) {
            Consts.getFontForBoards().draw(myGame.getBatch(), leader.getScoreRank(), x, height);

            String userDisplayName = leader.getUserDisplayName();
            if (leader.getUserId() == null) {

                userDisplayName = "(" + userDisplayName + ")";
            } else if (leader.isCurrentPlayer()) {

                userDisplayName = "*" + userDisplayName;
            }
            Consts.getFontForBoards().draw(myGame.getBatch(), userDisplayName, x + Consts.getWIDTH() / 4f, height);

            Consts.getFontForBoards().draw(myGame.getBatch(), leader.getFormattedValue(),
                    x + Consts.getWIDTH() / 2f, height);
            Consts.getFontForBoards().draw(myGame.getBatch(), leader.getScoreTag(),
                    x + Consts.getWIDTH() * 3 / 4f, height);
            height = (int) (height - glyphLayout.height - delta);
        }

        myGame.getBatch().end();
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
