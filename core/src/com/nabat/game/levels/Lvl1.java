package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nabat.game.RectZone;
import java.util.ArrayList;


public class Lvl1 {


    final int MAX_COUNT_OF_PERIOD = 6000; //30sec
    private final float period = 0.005f;
    ArrayList<ArrayList<RectZone>> arrayLists;
    String path = "levels/1/1"; //levels/1/2
    Color color;
    long startPoint;
    FileHandle fileHandle;
    int countOfPeriod = 0;
    int i = 0;
    Thread thread;
    //File file;
    ShapeRenderer timeLine;
    private float timeSeconds = 0f;

    public Lvl1(Color color) {
        arrayLists = new ArrayList<>();
        this.color = color;
        timeLine = new ShapeRenderer();


        try {
            fileHandle = Gdx.files.internal(path);

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    public void load() {
        arrayLists = setLevel(path, 20, 1);
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

    public void timeLineDraw() {

        if (countOfPeriod <= MAX_COUNT_OF_PERIOD) {

            timeSeconds += Gdx.graphics.getRawDeltaTime();
            if (timeSeconds > period) {

                //draw line
                timeLine.begin(ShapeRenderer.ShapeType.Filled);

                timeLine.setColor(Color.BLUE);
                timeLine.rect(0, 0,
                        Gdx.graphics.getWidth() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD), 50);
                timeLine.end();

                timeSeconds -= period;
                countOfPeriod++;
            }
        }

    }

    public void dispose() {

    }

    ArrayList<ArrayList<RectZone>> setLevel(String path, int size, int lvl) {
        // генерим отрезок экранов в нужном файле
        ArrayList<ArrayList<RectZone>> list = new ArrayList<>();

        /*startPoint = ThreadLocalRandom.current().nextLong(0L,
                (fileHandle.length() - 1 - size * 4L * 3 * lvl));*/

        byte[] buf = fileHandle.readBytes();
        int[] e = new int[buf.length / 4];
        for (int bc = 0; bc < buf.length / 4; bc++) {

            e[bc] = (((buf[bc * 4] & 0xff) << 24) | ((buf[bc * 4 + 1] & 0xff) << 16) |
                    ((buf[bc * 4 + 2] & 0xff) << 8) | (buf[bc * 4 + 3] & 0xff));
        }

        /*ByteBuffer byteBuffer = ByteBuffer.wrap(buf);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        int[] e = (intBuffer.array());*/


        for (int p = 0; p < size; p++) {

            ArrayList<RectZone> doubles = new ArrayList<>();

            for (int t = 0; t < lvl; t++) {

                int[] b = new int[3];

                int u = (t + p) * 3;
                b[0] = e[u];
                b[1] = e[u + 1];
                b[2] = e[u + 2];

                doubles.add(new RectZone(
                        b[0], b[1],
                        b[2], b[2],
                        Color.BLACK));
            }
            list.add(doubles);

        }

        return list;

        /*//AssetFileDescriptor assetFileDescriptor = activity.getAssets().openFd(path);
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
        }*/

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
