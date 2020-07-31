package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nabat.game.Consts;
import com.nabat.game.RectZone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LevelFactory {

    private final int MAX_COUNT_OF_PERIOD; //30sec = 6000
    private final float period = 0.005f;
    private final String path; //levels/1/2
    private final float LOSE_TO_SCREEN = 7.5f;
    private final Color color;
    private final ShapeRenderer timeLine;
    private final ShapeRenderer timeLineEnd;
    private final BitmapFont font;
    private final BitmapFont fontForCount;
    private final BitmapFont fontForCountMiss;
    private final SpriteBatch batch;
    private final int sizeOfScreens;
    private final int lvl;
    private ArrayList<ArrayList<RectZone>> arrayLists;
    private int countOfPeriod = 0;
    private int i = 0;
    private boolean isLose = false;
    private float timeSeconds = 0f;
    private int countOfSquare = 0;
    private int countOfMiss = 0;
    private boolean setMenu = false;

    public LevelFactory(Color color, float levelTime, String pathToFile, int sizeOfScreens, int lvl) {

        MAX_COUNT_OF_PERIOD = (int) (levelTime / period);
        path = pathToFile;
        this.sizeOfScreens = sizeOfScreens;
        this.lvl = lvl;

        arrayLists = new ArrayList<>();

        this.color = color;
        timeLine = new ShapeRenderer();
        timeLineEnd = new ShapeRenderer();
        batch = new SpriteBatch();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / LOSE_TO_SCREEN);
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

    public void draw() {

        if (isLose) {
            batch.begin();
            font.draw(batch, Consts.getLOSE(),
                    Gdx.app.getGraphics().getWidth() / 3f, Gdx.app.getGraphics().getHeight() / 2f);
            batch.end();

            if (Gdx.input.isTouched()){

                setMenu = true;
            }

        } else {
            if (arrayLists != null) {

                if (i < arrayLists.size()) {
                    for (int j = 0; j < arrayLists.get(i).size(); j++) {

                        try {


                            arrayLists.get(i).get(j).draw();

                            batch.begin();
                            fontForCount.draw(batch, countOfSquare + "",
                                    50f, Gdx.app.getGraphics().getHeight() - 50f);
                            fontForCountMiss.draw(batch, countOfMiss + "",
                                    Gdx.app.getGraphics().getWidth() - 100f,
                                    Gdx.app.getGraphics().getHeight() - 50f);

                            batch.end();
                            timeLineDraw();

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
            }
        }
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
                        Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        50 * Consts.getScaleY());

                timeLineEnd.setColor(Color.WHITE);
                timeLineEnd.rect(Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD) -
                                Gdx.app.getGraphics().getWidth() / 50f,
                        0, Gdx.app.getGraphics().getWidth() / 50f,
                        50 * Consts.getScaleY());

                timeLine.end();
                timeLineEnd.end();
                if (Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD) < 0.1f) {
                    isLose = true;
                }

                timeSeconds -= period;
                countOfPeriod++;
            }
        }

    }

    public void dispose() {
        batch.dispose();
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
