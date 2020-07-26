package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nabat.game.RectZone;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Lvl1 {


    ArrayList<ArrayList<RectZone>> arrayLists;
    String path = "levels/1/1"; //levels/1/2
    Color color;
    long startPoint;
    FileHandle fileHandle;
    private float timeSeconds = 0f;
    private final float period = 0.05f;
    final int MAX_COUNT_OF_PERIOD = 600; //30sec
    int countOfPeriod = 0;
    int i = 0;
    Thread thread;
    File file;
    boolean e;
    ShapeRenderer timeLine;

    public Lvl1(Color color) {
        arrayLists = new ArrayList<>();
        this.color = color;
        timeLine = new ShapeRenderer();
        timeLine.setColor(Color.BLUE);

        try {
            fileHandle = Gdx.files.internal(path);
            e = fileHandle.exists();
            file = fileHandle.file();
            e = file.exists();
            e = fileHandle.isDirectory();
            e = file.canRead();
            e = file.canWrite();
            e = file.isFile();
            e = file.setReadable(true);
            e = file.canRead();

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    public void load() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    arrayLists = setLevel(path, 50, 1);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        };

        thread = new Thread(runnable);
        thread.start();


    }

    public void draw() {

        if (arrayLists != null) {

            if (i < arrayLists.size()) {
                for (int j = 0; j < arrayLists.get(i).size(); j++) {
                    try {

                        thread.join();
                        arrayLists.get(i).get(j).draw();
                        timeLineDraw();

                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
    }

    public void timeLineDraw(){

        if (countOfPeriod<=MAX_COUNT_OF_PERIOD){

            timeSeconds += Gdx.graphics.getRawDeltaTime();
            if (timeSeconds>period){

                //draw line
                timeLine.begin();
                timeLine.rect(0,0,
                        Gdx.graphics.getWidth()*(1f-(float)countOfPeriod/MAX_COUNT_OF_PERIOD),30);
                timeLine.end();

                timeSeconds -=period;
                countOfPeriod++;
            }
        }

    }

    public void dispose() {

    }

    ArrayList<ArrayList<RectZone>> setLevel(String path, int size, int lvl) throws IOException {
        // генерим отрезок экранов в нужном файле
        ArrayList<ArrayList<RectZone>> list = new ArrayList<>();

        //AssetFileDescriptor assetFileDescriptor = activity.getAssets().openFd(path);
        InputStream inputStream = fileHandle.read();

        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {

            //файл имеет следующую структуру: одна запись - три инта, на одном "экране" lvl записей. Всего может быть очень много экранов.

            //считаем рандомную точку начала отрезка.
            startPoint = ThreadLocalRandom.current().nextLong(0L,
                    (fileHandle.length() - 1 - size * 4L * 3 * lvl));
            dataInputStream.skipBytes((int) startPoint);

            for (int p = 0; p < size; p++) {

                ArrayList<RectZone> doubles = new ArrayList<>();

                for (int t = 0; t < lvl; t++) {

                    int[] b = new int[3];

                    for (int j = 0; j < 3; j++) {
                        b[j] = (dataInputStream.readInt());
                    }
                    doubles.add(new RectZone(
                            (b[0]),
                            (b[1]),
                            ((b[0] + b[2])),
                            ((b[1] + b[2])),
                            Color.BLACK));
                }
                list.add(doubles);
            }
            return list;
        } catch (FileNotFoundException exception) {

            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }

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
