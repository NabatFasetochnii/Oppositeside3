package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Array;
import com.nabat.game.Consts;
import com.nabat.game.Loader;
import com.nabat.game.MyGame;
import com.nabat.game.Str;
import com.nabat.game.inputs.InputForScroll;
import de.golfgl.gdxgamesvcs.achievement.IAchievement;

import java.util.ArrayList;

public class AchievementsScreen implements Screen {

    private final InputForScroll inputForScroll;
    private final ArrayList<Str> list = new ArrayList<>();
    private final int deltA;
    private final int x;
    private final float xForP;
    private final int rectS;
    MyGame myGame;
    Array<IAchievement> achievements;
    private int height;
    private GlyphLayout glyphLayout = new GlyphLayout(Consts.getFontForBoards(), "100%");
    private int scroll = 0;
    private final float zeroPoint;

    public AchievementsScreen(MyGame myGame, Array<IAchievement> achievements) {
        this.myGame = myGame;
        this.achievements = achievements;
        deltA = Consts.getWIDTH() / 100;
        rectS = Consts.getWIDTH() / 10;
        height = Consts.getHEIGHT() - rectS - deltA;
        zeroPoint = height;
        x = deltA;
        inputForScroll = new InputForScroll(myGame, rectS, height, this);
        xForP = Consts.getWIDTH() - glyphLayout.width - deltA;
    }

    public int getScroll() {
        return scroll;
    }

    public void setScroll(int scroll) {

        if (list.get(0).getY() - scroll > zeroPoint &&
                list.get(list.size() - 1).getY() - scroll <= rectS + deltA + list.get(list.size() - 1).getH()) {
            this.scroll = scroll;
            for (Str str : list) {
                str.setY(str.getY() - scroll);
            }
        }

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputForScroll);
        for (IAchievement ach : achievements) {
            String[] t;

            glyphLayout = new GlyphLayout(Consts.getFontForBoards(), ach.getTitle());

            if (glyphLayout.width < Consts.getWIDTH() / 2f - deltA) {

                list.add(new Str(x, height, glyphLayout.height, xForP,
                        ach.getTitle(), ach.isUnlocked() ? "Unlocked" : "Locked",
                        (int) (ach.getCompletionPercentage() * 100) + "%", myGame));
            } else {

                StringBuilder s = new StringBuilder(ach.getTitle());
                t = s.toString().split(" ");
                s = new StringBuilder();
                StringBuilder str = new StringBuilder();
                for (int y = 0; y < t.length; y++) {

                    if (y < t.length - 3) {

                        str.append(t[y]).append(" ").append(t[y + 1]).append(" ").
                                append(t[y + 2]).append(" ").append(t[y + 3]);
                        glyphLayout = new GlyphLayout(Consts.getFontForBoards(), str.toString());
                        if (glyphLayout.width < Consts.getWIDTH() / 2f - deltA) {

                            if (y + 3 != t.length - 1) {
                                s.append(str).append('\n');
                            } else {
                                s.append(str);
                            }
                            str.delete(0, str.length());
                            y += 3;
                            continue;
                        } else {
                            str.delete(0, str.length());
                        }
                    }

                    if (y < t.length - 2) {

                        str.append(t[y]).append(" ").append(t[y + 1]).append(" ").append(t[y + 2]);
                        glyphLayout = new GlyphLayout(Consts.getFontForBoards(), str.toString());
                        if (glyphLayout.width < Consts.getWIDTH() / 2f - deltA) {

                            if (y + 2 != t.length - 1) {
                                s.append(str).append('\n');
                            } else {
                                s.append(str);
                            }
                            str.delete(0, str.length());
                            y += 2;
                            continue;
                        } else {
                            str.delete(0, str.length());
                        }
                    }
                    if (y < t.length - 1) {
                        str.append(t[y]).append(" ").append(t[y + 1]);

                        glyphLayout = new GlyphLayout(Consts.getFontForBoards(), str.toString());
                        if (glyphLayout.width < Consts.getWIDTH() / 2f - deltA) {

                            if (y + 1 != t.length - 1) {
                                s.append(str).append('\n');
                            } else {
                                s.append(str);
                            }

                            y++;
                            str.delete(0, str.length());
                        } else {
                            s.append(t[y]).append('\n');
                        }

                        str.delete(0, str.length());
                    } else {

                        s.append(t[y]);

                    }


                }
                glyphLayout = new GlyphLayout(Consts.getFontForBoards(), s.toString());
                list.add(new Str(x, height, glyphLayout.height, xForP,
                        s.toString(), ach.isUnlocked() ? "Unlocked" : "Locked",
                        (int) (ach.getCompletionPercentage() * 100) + "%", myGame));
            }
            height = (int) (height - glyphLayout.height - deltA * 8);

        }
    }

    @Override
    public void render(float delta) {

        Consts.clear();

        myGame.getBatch().begin();

        for (Str str :
                list) {
            str.draw();
        }
        myGame.getBatch().draw(Loader.getSettingsButton(), Consts.getWIDTH() - rectS, Consts.getHEIGHT() - rectS,
                rectS, rectS);
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
