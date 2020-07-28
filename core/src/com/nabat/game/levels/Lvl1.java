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
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Lvl1 {

    private final int MAX_COUNT_OF_PERIOD = 300; //30sec = 6000
    private final float period = 0.005f;
    private final String path = "levels/1/1"; //levels/1/2
    private final float LOSE_TO_SCREEN = 7.5f;
    private ArrayList<ArrayList<RectZone>> arrayLists;
    private final Color color;
    private int countOfPeriod = 0;
    private int i = 0;
    private final ShapeRenderer timeLine;
    private boolean isLose = false;
    private final BitmapFont font;
    private final SpriteBatch batch;
    private float timeSeconds = 0f;

    public Lvl1(Color color) {
        arrayLists = new ArrayList<>();
        this.color = color;
        timeLine = new ShapeRenderer();
        batch = new SpriteBatch();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Consts.getTtfPath()));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Gdx.app.getGraphics().getWidth() / LOSE_TO_SCREEN);
        parameter.color = Color.BLACK;
        parameter.borderColor = Color.RED;
        parameter.borderWidth = 5;
        font = generator.generateFont(parameter);
        generator.dispose();



    }

    public void load() {
        arrayLists = setLevel(path, 1500, 1);
       /* Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        };

        thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }*/

    }

    public void draw() {

        if (isLose) {
            batch.begin();
            font.draw(batch, Consts.getLOSE(),
                    Gdx.app.getGraphics().getWidth() / 3f, Gdx.app.getGraphics().getHeight() / 2f);
            batch.end();
        } else {
            if (arrayLists != null) {

                if (i < arrayLists.size()) {
                    for (int j = 0; j < arrayLists.get(i).size(); j++) {
                        try {

                            //thread.join();
                            arrayLists.get(i).get(j).draw();
                            timeLineDraw();

                        } catch (Exception ignored) {
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

                timeLine.setColor(Color.GREEN);
                timeLine.rect(0, 0,
                        Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        50*Consts.getScaleY());
                timeLine.end();
                if (Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD) < 0.1f) {
                    isLose = true;
                }

                timeSeconds -= period;
                countOfPeriod++;
            }
        }

    }

    public void dispose() {

    }

    ArrayList<ArrayList<RectZone>> setLevel(String path, int size, int lvl) {
        long startPoint;
        FileHandle fileHandle;
        // генерим отрезок экранов в нужном файле
        ArrayList<ArrayList<RectZone>> list = new ArrayList<>();

        fileHandle = Gdx.files.internal(path);



        byte[] buf = fileHandle.readBytes();
        int[] e = new int[buf.length / 4];
        for (int bc = 0; bc < buf.length / 4; bc++) {

            e[bc] = (((buf[bc * 4] & 0xff) << 24) | ((buf[bc * 4 + 1] & 0xff) << 16) |
                    ((buf[bc * 4 + 2] & 0xff) << 8) | (buf[bc * 4 + 3] & 0xff));
        }

        startPoint = ThreadLocalRandom.current().
                nextInt(0, (e.length - 1 - size * 3 * lvl));//TODO дописать рандомайз

        for (int p = 0; p < size; p++) {

            ArrayList<RectZone> doubles = new ArrayList<>();

            for (int t = 0; t < lvl; t++) {

                int[] b = new int[3];

                int u = (t + p) * 3;
                b[0] = e[u];
                b[1] = e[u + 1];
                b[2] = e[u + 2];

                doubles.add(new RectZone(
                        (int) (b[0] * Consts.getScaleX()), (int) (b[1] * Consts.getScaleY()),
                        (int) (b[2] * Consts.getScaleX()), (int) (b[2] * Consts.getScaleY()),
                        color));
            }
            list.add(doubles);

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
