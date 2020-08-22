package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForGame;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LevelFactory implements Screen {

    private final int MAX_COUNT_OF_PERIOD; //30sec = 6000
    private final float period = 0.005f;
    private final String path; //levels/1/2
    private final Color color;
    private final ShapeRenderer timeLine;
    private final ShapeRenderer timeLineEnd;
    private final int sizeOfScreens;
    private final int lvl;
    private final MyGame myGame;
    private final float levelTime;
    private final int lvlName;
    private int time = 0;
    private int y;
    private float rotationSpeed; //deg
    private ArrayList<ArrayList<RectZone>> arrayLists;
    private int countOfPeriod = 0;
    private int i = 0;
    private boolean isLose = false;
    private float timeSeconds = 0f;
    private int countOfSquare = 0;
    private int countOfMiss = 0;
    private float text_Y = Consts.getHEIGHT() / 2f;
    private boolean isRotation = false;
    private boolean isDot = false;
    private int MAX_MISS = 3;

    public LevelFactory(Color color, float levelTime, String pathToFile, int sizeOfScreens, int lvl, MyGame myGame, int lvlName) {
        this.levelTime = levelTime;
        MAX_COUNT_OF_PERIOD = (int) (levelTime / period);
        path = pathToFile;
        this.sizeOfScreens = sizeOfScreens;
        this.lvl = lvl;
        this.myGame = myGame;
        this.lvlName = lvlName;
        arrayLists = new ArrayList<>();

        this.color = color;
        timeLine = new ShapeRenderer();
        timeLineEnd = new ShapeRenderer();

    }

    public int getLvlName() {
        return lvlName;
    }

    public boolean isDot() {
        return isDot;
    }

    public void setDot(boolean isDot) {
        this.isDot = isDot;
        miss();

    }

    private void miss() {

        if (isDot && isRotation) {
            MAX_MISS = 7;
        } else if (isDot) {
            MAX_MISS = 4;
        } else if (isRotation) {
            MAX_MISS = 5;
        }

    }

    public boolean isRotation() {
        return isRotation;
    }

    public void setRotation(boolean rotation, float rot) {
        rotationSpeed = rot;
        isRotation = rotation;
        miss();
    }

    public int getSizeOfScreens() {
        return sizeOfScreens;
    }

    public float getLevelTime() {
        return levelTime;
    }

    public int getLvl() {
        return lvl;
    }

    public void upCountOfSquare() {

        countOfSquare += lvl;
    }

    public void upCountOfMiss() {

        countOfMiss++;
        if (countOfMiss == MAX_MISS) {
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

                Color right = new Color(Color.rgb888(117, 155, 251));//
                Color left = new Color(Color.rgb888(46, 111, 200));//
//                timeLine.setColor(Color.GREEN);
                timeLine.rect(0, 0,
                        Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        50 * Consts.getScaleY(), left, right, right, left);

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

    public void endLevel(String text, BitmapFont font1) {

        Gdx.input.setInputProcessor(null);
        myGame.getBatch().begin();
        font1.draw(myGame.getBatch(), text,
                Consts.getWIDTH() / 3f, text_Y);
        myGame.getBatch().end();

        int timeMax = 20;

        if (time > timeMax) {

            Gdx.input.setInputProcessor(new InputProcessor() {


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
                    return true;
                }

                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                    int points = countOfSquare - countOfMiss;

                    if (points > 0) {

                        switch (lvlName) {
                            case 1: {
                                if (points > Consts.getMap().get(Consts.getCOUNT1())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT1()));
                                    Consts.getMap().put(Consts.getCOUNT1(), points);
                                }

                                break;
                            }
                            case 2: {

                                if (points > Consts.getMap().get(Consts.getCOUNT2())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT2()));
                                    Consts.getMap().put(Consts.getCOUNT2(), points);
                                }
                                break;
                            }
                            case 3: {

                                if (points > Consts.getMap().get(Consts.getCOUNT3())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT3()));
                                    Consts.getMap().put(Consts.getCOUNT3(), points);
                                }
                                break;
                            }
                            case 4: {

                                if (points > Consts.getMap().get(Consts.getCOUNT4())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT4()));
                                    Consts.getMap().put(Consts.getCOUNT4(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 11: {
                                if (points > Consts.getMap().get(Consts.getCOUNT11())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT11()));
                                    Consts.getMap().put(Consts.getCOUNT11(), points);
                                }

                                break;
                            }
                            case 21: {

                                if (points > Consts.getMap().get(Consts.getCOUNT21())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT21()));
                                    Consts.getMap().put(Consts.getCOUNT21(), points);
                                }
                                break;
                            }
                            case 31: {

                                if (points > Consts.getMap().get(Consts.getCOUNT31())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT31()));
                                    Consts.getMap().put(Consts.getCOUNT31(), points);
                                }
                                break;
                            }
                            case 41: {

                                if (points > Consts.getMap().get(Consts.getCOUNT41())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT41()));
                                    Consts.getMap().put(Consts.getCOUNT41(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 111: {
                                if (points > Consts.getMap().get(Consts.getCOUNT111())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT111()));
                                    Consts.getMap().put(Consts.getCOUNT111(), points);
                                }

                                break;
                            }
                            case 211: {

                                if (points > Consts.getMap().get(Consts.getCOUNT211())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT211()));
                                    Consts.getMap().put(Consts.getCOUNT211(), points);
                                }
                                break;
                            }
                            case 311: {

                                if (points > Consts.getMap().get(Consts.getCOUNT311())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT311()));
                                    Consts.getMap().put(Consts.getCOUNT311(), points);
                                }
                                break;
                            }
                            case 411: {

                                if (points > Consts.getMap().get(Consts.getCOUNT411())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT411()));
                                    Consts.getMap().put(Consts.getCOUNT411(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 12: {
                                if (points > Consts.getMap().get(Consts.getCOUNT12())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT12()));
                                    Consts.getMap().put(Consts.getCOUNT12(), points);
                                }

                                break;
                            }
                            case 22: {

                                if (points > Consts.getMap().get(Consts.getCOUNT22())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT22()));
                                    Consts.getMap().put(Consts.getCOUNT22(), points);
                                }
                                break;
                            }
                            case 32: {

                                if (points > Consts.getMap().get(Consts.getCOUNT32())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT32()));
                                    Consts.getMap().put(Consts.getCOUNT32(), points);
                                }
                                break;
                            }
                            case 42: {

                                if (points > Consts.getMap().get(Consts.getCOUNT42())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT42()));
                                    Consts.getMap().put(Consts.getCOUNT42(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 122: {
                                if (points > Consts.getMap().get(Consts.getCOUNT122())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT122()));
                                    Consts.getMap().put(Consts.getCOUNT122(), points);
                                }

                                break;
                            }
                            case 222: {

                                if (points > Consts.getMap().get(Consts.getCOUNT222())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT222()));
                                    Consts.getMap().put(Consts.getCOUNT222(), points);
                                }
                                break;
                            }
                            case 322: {

                                if (points > Consts.getMap().get(Consts.getCOUNT322())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT322()));
                                    Consts.getMap().put(Consts.getCOUNT322(), points);
                                }
                                break;
                            }
                            case 422: {

                                if (points > Consts.getMap().get(Consts.getCOUNT422())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT422()));
                                    Consts.getMap().put(Consts.getCOUNT422(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 10: {
                                if (points > Consts.getMap().get(Consts.getCOUNT1R())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT1R()));
                                    Consts.getMap().put(Consts.getCOUNT1R(), points);
                                }

                                break;
                            }
                            case 20: {

                                if (points > Consts.getMap().get(Consts.getCOUNT2R())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT2R()));
                                    Consts.getMap().put(Consts.getCOUNT2R(), points);
                                }
                                break;
                            }
                            case 30: {

                                if (points > Consts.getMap().get(Consts.getCOUNT3R())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT3R()));
                                    Consts.getMap().put(Consts.getCOUNT3R(), points);
                                }
                                break;
                            }
                            case 40: {

                                if (points > Consts.getMap().get(Consts.getCOUNT4R())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT4R()));
                                    Consts.getMap().put(Consts.getCOUNT4R(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 101: {
                                if (points > Consts.getMap().get(Consts.getCOUNT1R1())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT1R1()));
                                    Consts.getMap().put(Consts.getCOUNT1R1(), points);
                                }

                                break;
                            }
                            case 201: {

                                if (points > Consts.getMap().get(Consts.getCOUNT2R1())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT2R1()));
                                    Consts.getMap().put(Consts.getCOUNT2R1(), points);
                                }
                                break;
                            }
                            case 301: {

                                if (points > Consts.getMap().get(Consts.getCOUNT3R1())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT3R1()));
                                    Consts.getMap().put(Consts.getCOUNT3R1(), points);
                                }
                                break;
                            }
                            case 401: {

                                if (points > Consts.getMap().get(Consts.getCOUNT4R1())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT4R1()));
                                    Consts.getMap().put(Consts.getCOUNT4R1(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 102: {
                                if (points > Consts.getMap().get(Consts.getCOUNT1R2())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT1R2()));
                                    Consts.getMap().put(Consts.getCOUNT1R2(), points);
                                }

                                break;
                            }
                            case 202: {

                                if (points > Consts.getMap().get(Consts.getCOUNT2R2())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT2R2()));
                                    Consts.getMap().put(Consts.getCOUNT2R2(), points);
                                }
                                break;
                            }
                            case 302: {

                                if (points > Consts.getMap().get(Consts.getCOUNT3R2())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT3R2()));
                                    Consts.getMap().put(Consts.getCOUNT3R2(), points);
                                }
                                break;
                            }
                            case 402: {

                                if (points > Consts.getMap().get(Consts.getCOUNT4R2())) {

                                    Consts.getMap().put(Consts.getCOUNT0(),
                                            Consts.getMap().get(Consts.getCOUNT0()) +
                                                    points - Consts.getMap().get(Consts.getCOUNT4R2()));
                                    Consts.getMap().put(Consts.getCOUNT4R2(), points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                        }

                        myGame.updatePref();

                    }
                    isLose = false;
                    countOfMiss = 0;
                    countOfSquare = 0;
                    countOfPeriod = 0;
                    i = 0;
                    arrayLists = null;
                    time = 0;
                    text_Y = Consts.getHEIGHT() / 2f;
                    myGame.setScreen(myGame.getLevels());

                    return false;
                }

                @Override
                public boolean touchDragged(int screenX, int screenY, int pointer) {

                    int dy = (screenY - y);
                    text_Y = (text_Y - dy);
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
            });

        } else {
            time++;
        }


    }

    @Override
    public void show() {
        load();
        Gdx.input.setInputProcessor(new InputForGame(this));

    }

    @Override
    public void render(float delta) {

        Consts.clear();

        if (isLose) {


            endLevel(Consts.getLOSE(), Consts.getFontForLose());

        } else {

            if (arrayLists != null) {

                if (i < arrayLists.size()) {
                    for (int j = 0; j < arrayLists.get(i).size(); j++) {

                        try {


                            arrayLists.get(i).get(j).draw();
                            if (arrayLists.get(i).get(j).getHeightS() < 2) {

                                i++;
                            }


                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        myGame.getBatch().begin();
                        Consts.getFontForCount().draw(myGame.getBatch(), countOfSquare + "",
                                50f, Gdx.app.getGraphics().getHeight() - 50f);
                        Consts.getFontForCountMiss().draw(myGame.getBatch(), countOfMiss + "",
                                Gdx.app.getGraphics().getWidth() - 100f,
                                Gdx.app.getGraphics().getHeight() - 50f);

                        myGame.getBatch().end();
                        timeLineDraw();
                    }
                } else {
                    endLevel(Consts.getWIN(), Consts.getFontForWin());
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

    }

    ArrayList<ArrayList<RectZone>> setLevel(String path, int size, int lvl) {

        FileHandle fileHandle;
        // генерим отрезок экранов в нужном файле
        ArrayList<ArrayList<RectZone>> list = new ArrayList<>();

        fileHandle = Gdx.files.internal(path);

        long handleLength = fileHandle.length();
        long fileLength = handleLength / (3L * lvl * 4);

        long startPoint = ThreadLocalRandom.current().
                nextLong((fileLength + 1 - size));
        startPoint *= 3L * lvl * 4;

        byte[] buf = new byte[size * 3 * lvl * 4];

        try {
            InputStream input = fileHandle.read();

            long sk = input.skip(startPoint);
            int sk2 = input.read(buf, 0, buf.length);

            if (sk == 0 && sk2 == -1) {
                return null;
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        int[] e = new int[buf.length / 4];
        for (int bc = 0; bc < buf.length / 4; bc++) {

            e[bc] = (((buf[bc * 4] & 0xff) << 24) | ((buf[bc * 4 + 1] & 0xff) << 16) |
                    ((buf[bc * 4 + 2] & 0xff) << 8) | (buf[bc * 4 + 3] & 0xff));
        }

        for (int p = 0; p < size; p++) {

            ArrayList<RectZone> doubles = new ArrayList<>();
            int u;

            for (int t = 0; t < lvl; t++) {

                u = (t + p * lvl) * 3;
                int[] b = new int[3];
                b[0] = (int) (e[u] * Consts.getScaleX());
                b[1] = (int) (e[u + 1] * Consts.getScaleY());
                b[2] = (int) (e[u + 2] * Consts.getScaleXY());

                doubles.add(new RectZone(
                        b[0], b[1], b[2], b[2],
                        color, isRotation, rotationSpeed, isDot));

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
