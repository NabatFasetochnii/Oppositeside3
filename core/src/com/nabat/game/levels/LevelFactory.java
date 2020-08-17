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


                    myGame.setScreen(myGame.getLevels());


                    int points = countOfSquare - countOfMiss;

                    if (points > 0) {

                        switch (lvlName) {

                            case 1: {


                                if (points > Consts.getCountOfPoints1()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints1());
                                    Consts.setCountOfPoints1(points);

                                }

                                break;
                            }
                            case 2: {

                                if (points > Consts.getCountOfPoints2()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints2());
                                    Consts.setCountOfPoints2(points);
                                }
                                break;
                            }
                            case 3: {

                                if (points > Consts.getCountOfPoints3()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints3());
                                    Consts.setCountOfPoints3(points);
                                }

                                break;
                            }
                            case 4: {

                                if (points > Consts.getCountOfPoints4()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints4());
                                    Consts.setCountOfPoints4(points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 11: { //продвинутый набор уровней
                                if (points > Consts.getCountOfPoints11()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints11());
                                    Consts.setCountOfPoints11(points);

                                }
                                break;
                            }
                            case 21: {
                                if (points > Consts.getCountOfPoints21()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints21());
                                    Consts.setCountOfPoints21(points);

                                }
                                break;
                            }
                            case 31: {
                                if (points > Consts.getCountOfPoints31()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints31());
                                    Consts.setCountOfPoints31(points);

                                }
                                break;
                            }
                            case 41: {
                                if (points > Consts.getCountOfPoints41()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints41());
                                    Consts.setCountOfPoints41(points);

                                }

                                break;
                            }
                            ////////////////////////////////////////

                            case 111: { //продвинутый набор уровней
                                if (points > Consts.getCountOfPoints111()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints111());
                                    Consts.setCountOfPoints111(points);

                                }
                                break;
                            }
                            case 211: {
                                if (points > Consts.getCountOfPoints211()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints211());
                                    Consts.setCountOfPoints211(points);

                                }
                                break;
                            }
                            case 311: {
                                if (points > Consts.getCountOfPoints311()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints311());
                                    Consts.setCountOfPoints311(points);

                                }
                                break;
                            }
                            case 411: {
                                if (points > Consts.getCountOfPoints411()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints411());
                                    Consts.setCountOfPoints411(points);

                                }

                                break;
                            }

                            ////////////////////////////////////////
                            case 12: {


                                if (points > Consts.getCountOfPoints12()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints12());
                                    Consts.setCountOfPoints12(points);

                                }

                                break;
                            }
                            case 22: {

                                if (points > Consts.getCountOfPoints22()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints22());
                                    Consts.setCountOfPoints22(points);
                                }
                                break;
                            }
                            case 32: {

                                if (points > Consts.getCountOfPoints32()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints32());
                                    Consts.setCountOfPoints32(points);
                                }

                                break;
                            }
                            case 42: {

                                if (points > Consts.getCountOfPoints42()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints42());
                                    Consts.setCountOfPoints42(points);
                                }
                                break;
                            }
                            ////////////////////////////////////////

                            case 121: { //продвинутый набор уровней
                                if (points > Consts.getCountOfPoints121()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints121());
                                    Consts.setCountOfPoints121(points);

                                }
                                break;
                            }
                            case 221: {
                                if (points > Consts.getCountOfPoints221()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints221());
                                    Consts.setCountOfPoints221(points);

                                }
                                break;
                            }
                            case 321: {
                                if (points > Consts.getCountOfPoints321()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints321());
                                    Consts.setCountOfPoints321(points);

                                }
                                break;
                            }
                            case 421: {
                                if (points > Consts.getCountOfPoints421()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints421());
                                    Consts.setCountOfPoints421(points);

                                }

                                break;
                            }

                            ////////////////////////////////////////
                            case 122: { //продвинутый набор уровней
                                if (points > Consts.getCountOfPoints122()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints122());
                                    Consts.setCountOfPoints122(points);

                                }
                                break;
                            }
                            case 222: {
                                if (points > Consts.getCountOfPoints222()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints222());
                                    Consts.setCountOfPoints222(points);

                                }
                                break;
                            }
                            case 322: {
                                if (points > Consts.getCountOfPoints322()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints322());
                                    Consts.setCountOfPoints322(points);

                                }
                                break;
                            }
                            case 422: {
                                if (points > Consts.getCountOfPoints422()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints422());
                                    Consts.setCountOfPoints422(points);

                                }

                                break;
                            }

                            ////////////////////////////////////////
                            case 10: { //набор уровней с кручением
                                if (points > Consts.getCountOfPoints1R())
                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints1R());
                                Consts.setCountOfPoints1R(points);
                                break;
                            }
                            case 20: {

                                if (points > Consts.getCountOfPoints2R()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints2R());
                                    Consts.setCountOfPoints2R(points);
                                }
                                break;
                            }

                            case 30: {

                                if (points > Consts.getCountOfPoints3R()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints3R());
                                    Consts.setCountOfPoints3R(points);
                                }
                                break;
                            }
                            case 40: {

                                if (points > Consts.getCountOfPoints4R()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints4R());
                                    Consts.setCountOfPoints4R(points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 101: { //набор уровней с кручением
                                if (points > Consts.getCountOfPoints1R1())
                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints1R1());
                                Consts.setCountOfPoints1R1(points);
                                break;
                            }
                            case 201: {

                                if (points > Consts.getCountOfPoints2R1()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints2R1());
                                    Consts.setCountOfPoints2R1(points);
                                }
                                break;
                            }

                            case 301: {

                                if (points > Consts.getCountOfPoints3R1()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints3R1());
                                    Consts.setCountOfPoints3R1(points);
                                }
                                break;
                            }
                            case 401: {

                                if (points > Consts.getCountOfPoints4R1()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints4R1());
                                    Consts.setCountOfPoints4R1(points);
                                }
                                break;
                            }
                            ////////////////////////////////////////
                            case 102: { //набор уровней с кручением
                                if (points > Consts.getCountOfPoints1R2())
                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints1R2());
                                Consts.setCountOfPoints1R2(points);
                                break;
                            }
                            case 202: {

                                if (points > Consts.getCountOfPoints2R2()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints2R2());
                                    Consts.setCountOfPoints2R2(points);
                                }
                                break;
                            }

                            case 302: {

                                if (points > Consts.getCountOfPoints3R2()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints3R2());
                                    Consts.setCountOfPoints3R2(points);
                                }
                                break;
                            }
                            case 402: {

                                if (points > Consts.getCountOfPoints4R2()) {

                                    Consts.setCountOfAllPoints(Consts.getCountOfAllPoints() +
                                            points - Consts.getCountOfPoints4R2());
                                    Consts.setCountOfPoints4R2(points);
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
