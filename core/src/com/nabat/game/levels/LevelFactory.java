package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nabat.game.Consts;
import com.nabat.game.Game;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LevelFactory implements Screen {

    private final int MAX_COUNT_OF_PERIOD; //30sec = 6000
    private final float period = 0.005f;
    private final String path; //levels/1/2
    private final Color color;
    private final ShapeRenderer timeLine;
    private final ShapeRenderer timeLineEnd;
    private final BitmapFont font;
    private final BitmapFont fontForCount;
    private final BitmapFont fontForCountMiss;
    private final int sizeOfScreens;
    private final int lvl;
    Game game;
    private ArrayList<ArrayList<RectZone>> arrayLists;
    private int countOfPeriod = 0;
    private int i = 0;
    private boolean isLose = false;
    private float timeSeconds = 0f;
    private int countOfSquare = 0;
    private int countOfMiss = 0;
    private boolean setMenu = false;


    public LevelFactory(Color color, float levelTime, String pathToFile, int sizeOfScreens, int lvl, Game game) {

        MAX_COUNT_OF_PERIOD = (int) (levelTime / period);
        path = pathToFile;
        this.sizeOfScreens = sizeOfScreens;
        this.lvl = lvl;
        this.game = game;

        arrayLists = new ArrayList<>();

        this.color = color;
        timeLine = new ShapeRenderer();
        timeLineEnd = new ShapeRenderer();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / Consts.getLOSE_TO_SCREEN());
        parameter.color = Color.RED;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 5;
        font = generator.generateFont(parameter);

        parameter.color = Color.GREEN;
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / 10f);
        parameter.borderWidth = 3;
        fontForCount = generator.generateFont(parameter);

        parameter.color = Color.RED;

        fontForCountMiss = generator.generateFont(parameter);
        generator.dispose();


    }

    public int getLvl() {
        return lvl;
    }

    public boolean isSetMenu() {
        return setMenu;
    }

    public void setSetMenu(boolean setMenu) {
        this.setMenu = setMenu;
    }

    public boolean isLose() {
        return isLose;
    }

    public void setLose(boolean lose) {
        isLose = lose;
    }

    public void upCountOfSquare() {

        countOfSquare += lvl;
    }

    public void upCountOfMiss() {

        countOfMiss++;
        if (countOfMiss == 3) {
            isLose = true;
        }
    }

    public void load() {

        arrayLists = setLevel(path, sizeOfScreens, lvl);
    }

    public void timeLineDraw() {

        if (countOfPeriod <= MAX_COUNT_OF_PERIOD) {

            timeSeconds += Gdx.graphics.getRawDeltaTime();
            if (timeSeconds > period) {

                //draw line
                timeLine.begin(ShapeRenderer.ShapeType.Filled);
                timeLineEnd.begin(ShapeRenderer.ShapeType.Filled);


                timeLine.setColor(Color.GREEN);
                timeLine.rect(0, 0,
                        Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        50 * Consts.getScaleY());

                timeLineEnd.setColor(Color.WHITE);
                timeLineEnd.circle(Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        0, 50 * Consts.getScaleY());

                timeLine.end();
                timeLineEnd.end();
                if (Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD) < 0.1f) {
                    isLose = true;
                }

                timeSeconds -= period;
                countOfPeriod++;
            }
        }

    }

    @Override
    public void show() {
        load();
        Gdx.input.setInputProcessor(new InputForGame(this));

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (isLose) {

            game.getBatch().begin();
            font.draw(game.getBatch(), Consts.getLOSE(),
                    Consts.getWIDTH() / 3f, Consts.getHEIGHT() / 2f);
            game.getBatch().end();

            if (Gdx.input.isTouched()) {

                game.setScreen(game.getLevels());
                isLose = false;
                int a = Consts.getCountOfAllPoints() + countOfSquare - countOfMiss;
                if (a>0)
                Consts.setCountOfAllPoints(a);
                countOfMiss = 0;
                countOfSquare = 0;
                countOfPeriod = 0;
//                dispose();
            }

        } else {
            if (arrayLists != null) {

                if (i < arrayLists.size()) {
                    for (int j = 0; j < arrayLists.get(i).size(); j++) {

                        try {


                            arrayLists.get(i).get(j).draw();

                            game.getBatch().begin();
                            fontForCount.draw(game.getBatch(), countOfSquare + "",
                                    50f, Gdx.app.getGraphics().getHeight() - 50f);
                            fontForCountMiss.draw(game.getBatch(), countOfMiss + "",
                                    Gdx.app.getGraphics().getWidth() - 100f,
                                    Gdx.app.getGraphics().getHeight() - 50f);

                            game.getBatch().end();
                            timeLineDraw();

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
            }
        }
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

    public void dispose() {
        font.dispose();
    }

    ArrayList<ArrayList<RectZone>> setLevel(String path, int size, int lvl) {

        FileHandle fileHandle;
        // генерим отрезок экранов в нужном файле
        ArrayList<ArrayList<RectZone>> list = new ArrayList<>();

        fileHandle = Gdx.files.internal(path);
        long startPoint = ThreadLocalRandom.current().
                nextLong(0, (fileHandle.length() - 1L - size * 3L * lvl * 4));


        byte[] buf = new byte[size * 3 * lvl * 4];

        try {
            fileHandle.read().skip(startPoint);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        fileHandle.readBytes(buf, 0, buf.length);

        int[] e = new int[buf.length / 4];
        for (int bc = 0; bc < buf.length / 4; bc++) {

            e[bc] = (((buf[bc * 4] & 0xff) << 24) | ((buf[bc * 4 + 1] & 0xff) << 16) |
                    ((buf[bc * 4 + 2] & 0xff) << 8) | (buf[bc * 4 + 3] & 0xff));
        }

        for (int p = 0; p < size; p++) {

            ArrayList<RectZone> doubles = new ArrayList<>();
            int u;

            for (int t = 0; t < lvl; t++) {

                u = (t + p) * 3;
                int[] b = new int[3];
                b[0] = (int) (e[u] * Consts.getScaleX());
                b[1] = (int) (e[u + 1] * Consts.getScaleY());
                b[2] = (int) (e[u + 2] * Consts.getScaleXY());

                doubles.add(new RectZone(
                        b[0], b[1], b[2], b[2],
                        color));

            }
            if (doubles.size() != 0) {

                list.add(doubles);
            }


        }

        return list;

    }

    public ArrayList<ArrayList<RectZone>> getArrayLists() {
        return arrayLists;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }


}
