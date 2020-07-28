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

    private final int MAX_COUNT_OF_PERIOD = 3000; //30sec = 6000
    private final float period = 0.005f;
    private final String path = "levels/1/1"; //levels/1/2
    private final float LOSE_TO_SCREEN = 7.5f;
    private final Color color;
    private final ShapeRenderer timeLine;
    private final BitmapFont font;
    private final SpriteBatch batch;
    private ArrayList<ArrayList<RectZone>> arrayLists;
    private int countOfPeriod = 0;
    private int i = 0;
    private boolean isLose = false;
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
                        50 * Consts.getScaleY());
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

        int startPoint = ThreadLocalRandom.current().
                nextInt(0, (e.length - 1 - size * 3 * lvl));

        for (int p = 0; p < size; p++) {

            ArrayList<RectZone> doubles = new ArrayList<>();
            int u = 0;

            for (int t = 0; t < lvl; t++) {

                u = (t + p) * 3;

                if (u >= startPoint && u + 2 <= startPoint + size * 3 * lvl) {

                    int[] b = new int[3];
                    b[0] = (int) (e[u] * Consts.getScaleX());
                    b[1] = (int) (e[u + 1] * Consts.getScaleY());
                    b[2] = (int) (e[u + 2] * Consts.getScaleXY());

                    doubles.add(new RectZone(
                            b[0], b[1], b[2], b[2],
                            color));
                } else if (u+2 > startPoint + size * 3 * lvl) {
                    break;
                }


            }
            if (doubles.size()!=0){

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
