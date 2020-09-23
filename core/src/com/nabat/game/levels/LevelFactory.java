package com.nabat.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.nabat.game.Consts;
import com.nabat.game.MyGame;
import com.nabat.game.RectZone;
import com.nabat.game.inputs.InputForGame;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LevelFactory implements Screen {

    public final float rectsS = Consts.getWIDTH() / 10f;
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
    private final float countH;
    private final String LOSE;//константа текста победы
    private final String WIN;//константа текста проигрыша
    private final float timeLineH = 70 * Consts.getScaleY();
    public Sound sound;
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
    private int MAX_MISS;
    private boolean subEv = true;
    private boolean subEv2 = true;
    private boolean subEv3 = true;
    private boolean isAlf = false;

    public LevelFactory(Color color, float levelTime, String pathToFile,
                        int sizeOfScreens, int lvl, MyGame myGame, int lvlName) {
        this.levelTime = levelTime;
        this.sizeOfScreens = sizeOfScreens;
        this.lvl = lvl;
        this.myGame = myGame;
        this.lvlName = lvlName;
        this.color = color;

        MAX_COUNT_OF_PERIOD = (int) (levelTime / period);
        path = pathToFile;

        arrayLists = new ArrayList<>();
        timeLine = new ShapeRenderer();
        timeLineEnd = new ShapeRenderer();

        sound = Gdx.audio.newSound(Gdx.files.internal(Consts.getPathToSound()));
        GlyphLayout g = new GlyphLayout(myGame.loader.getFontForCount(), "000");
        countH = g.height;

        if (myGame.isRu) {
            LOSE = "Ты проиграл";
            WIN = "Ты выиграл!";
        } else {
            LOSE = "You lose";
            WIN = "You WIN!";
        }

    }

    public void setAlf(boolean alf) {
        isAlf = alf;
    }

    public MyGame getMyGame() {
        return myGame;
    }

    public int getLvlName() {
        return lvlName;
    }

    public boolean isDot() {
        return isDot;
    }

    public void setDot(boolean isDot) {
        this.isDot = isDot;
//        miss();

    }

    /*private void miss() {

        if (isDot && isRotation) {
            MAX_MISS = 7;
        } else if (isDot) {
            MAX_MISS = 4;
        } else if (isRotation) {
            MAX_MISS = 5;
        }

    }*/

    public boolean isRotation() {
        return isRotation;
    }

    public void setRotation(boolean rotation, float rot) {
        rotationSpeed = rot;
        isRotation = rotation;
//        miss();
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
                timeLine.rect(0, Consts.getHEIGHT() - timeLineH,
                        Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        timeLineH, left, right, right, left);

                timeLineEnd.setColor(Color.WHITE);
                timeLineEnd.circle(Consts.getWIDTH() * (1f - (float) countOfPeriod / MAX_COUNT_OF_PERIOD),
                        Consts.getHEIGHT() - timeLineH / 2, timeLineH);

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

        myGame.showAdToAFK();
        myGame.getBatch().begin();
        font1.draw(myGame.getBatch(), text,
                Consts.getWIDTH() / 3f, text_Y);
        myGame.getBatch().end();

        if (subEv2) {
            Gdx.input.setInputProcessor(null);

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
                    case 121: {
                        if (points > Consts.getMap().get(Consts.getCOUNT121())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT121()));
                            Consts.getMap().put(Consts.getCOUNT121(), points);
                        }

                        break;
                    }
                    case 221: {

                        if (points > Consts.getMap().get(Consts.getCOUNT221())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT221()));
                            Consts.getMap().put(Consts.getCOUNT221(), points);
                        }
                        break;
                    }
                    case 321: {

                        if (points > Consts.getMap().get(Consts.getCOUNT321())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT321()));
                            Consts.getMap().put(Consts.getCOUNT321(), points);
                        }
                        break;
                    }
                    case 421: {

                        if (points > Consts.getMap().get(Consts.getCOUNT421())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT421()));
                            Consts.getMap().put(Consts.getCOUNT421(), points);
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
                    case 13: {
                        if (points > Consts.getMap().get(Consts.getCOUNT13())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT13()));
                            Consts.getMap().put(Consts.getCOUNT13(), points);
                        }

                        break;
                    }
                    case 23: {

                        if (points > Consts.getMap().get(Consts.getCOUNT23())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT23()));
                            Consts.getMap().put(Consts.getCOUNT23(), points);
                        }
                        break;
                    }
                    case 33: {

                        if (points > Consts.getMap().get(Consts.getCOUNT33())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT33()));
                            Consts.getMap().put(Consts.getCOUNT33(), points);
                        }
                        break;
                    }
                    case 43: {

                        if (points > Consts.getMap().get(Consts.getCOUNT43())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT43()));
                            Consts.getMap().put(Consts.getCOUNT43(), points);
                        }
                        break;
                    }
                    ////////////////////////////////////////
                    case 131: {
                        if (points > Consts.getMap().get(Consts.getCOUNT131())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT131()));
                            Consts.getMap().put(Consts.getCOUNT131(), points);
                        }

                        break;
                    }
                    case 231: {

                        if (points > Consts.getMap().get(Consts.getCOUNT231())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT231()));
                            Consts.getMap().put(Consts.getCOUNT231(), points);
                        }
                        break;
                    }
                    case 331: {

                        if (points > Consts.getMap().get(Consts.getCOUNT331())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT331()));
                            Consts.getMap().put(Consts.getCOUNT331(), points);
                        }
                        break;
                    }
                    case 431: {

                        if (points > Consts.getMap().get(Consts.getCOUNT431())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT431()));
                            Consts.getMap().put(Consts.getCOUNT431(), points);
                        }
                        break;
                    }
                    ////////////////////////////////////////
                    case 132: {
                        if (points > Consts.getMap().get(Consts.getCOUNT132())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT132()));
                            Consts.getMap().put(Consts.getCOUNT132(), points);
                        }

                        break;
                    }
                    case 232: {

                        if (points > Consts.getMap().get(Consts.getCOUNT232())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT232()));
                            Consts.getMap().put(Consts.getCOUNT232(), points);
                        }
                        break;
                    }
                    case 332: {

                        if (points > Consts.getMap().get(Consts.getCOUNT332())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT332()));
                            Consts.getMap().put(Consts.getCOUNT332(), points);
                        }
                        break;
                    }
                    case 432: {

                        if (points > Consts.getMap().get(Consts.getCOUNT432())) {

                            Consts.getMap().put(Consts.getCOUNT0(),
                                    Consts.getMap().get(Consts.getCOUNT0()) +
                                            points - Consts.getMap().get(Consts.getCOUNT432()));
                            Consts.getMap().put(Consts.getCOUNT432(), points);
                        }
                        break;
                    }
                }

                myGame.updatePref();
                if (myGame.gsClient.submitToLeaderboard(Consts.getLEADERBOARD1(),
                        Consts.getMap().get(Consts.getCOUNT0()), myGame.gsClient.getGameServiceId())) {
                    Gdx.app.log("lvlfact", "leaderboard was loaded");
                } else {
                    Gdx.app.log("lvlfact", "problem with leaderboard");
                }

            }

            if (Consts.getMap().get(Consts.getCOUNT0()) >= 69) {

                myGame.gsClient.unlockAchievement(Consts.getNICE());
            }

            if (Consts.getMap().get(Consts.getCOUNT0()) >= 666) {

                myGame.gsClient.unlockAchievement(Consts.getTheDevilHimself());
            }
            if (Consts.getMap().get(Consts.getCOUNT0()) >= 6969) {

                myGame.gsClient.unlockAchievement(Consts.getNICE2());
            }
            if (Consts.getMap().get(Consts.getCOUNT0()) >= 5000) {

                myGame.gsClient.unlockAchievement(Consts.getFastestFingersInTheWildWest());
            }
            if (Consts.getMap().get(Consts.getCOUNT0()) >= 14000) {

                myGame.gsClient.unlockAchievement(Consts.getIMPOSSIBLE());
            }
            if (Consts.getMap().get(Consts.getCOUNT0()) >= 14350) {

                myGame.gsClient.unlockAchievement(Consts.getIsThisAnRpg());
            }

            if (Consts.getMap().get(Consts.getCOUNT0()) >= 1000) {

                myGame.gsClient.unlockAchievement(Consts.getFastStart());
            }

            if (Consts.timeSpeed <= 3600 && Consts.getMap().get(Consts.getCOUNT0()) >= 14350) {
                myGame.gsClient.unlockAchievement(Consts.getSpeedRun());
            }
            subEv2 = false;
        }
//        int timeMax = 20;

        if (time > 20) {

            if (subEv3) {
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
                        Consts.time = 0;
                        y = screenY;
                        return true;
                    }

                    @Override
                    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                        if (MathUtils.randomBoolean(0.34f)) {
                            if (!Consts.isRemoveAds()) {
                                myGame.getAdsController().showBannerAd();
                            }
                        }
                        myGame.setScreen(myGame.getLevels());
                        sound.dispose();
                        return true;
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
                subEv3 = false;
            }
        } else {
            time++;
        }
    }

    @Override
    public void show() {
        load();
        Gdx.input.setInputProcessor(new InputForGame(this));
        MAX_MISS = (int) (sizeOfScreens * 0.5);
    }

    @Override
    public void render(float delta) {

        Consts.clear();
        if (isLose) {
            if (subEv) {
                myGame.gsClient.submitEvent(String.valueOf(-lvlName), 1);
                subEv = false;
            }

            endLevel(LOSE, myGame.loader.getFontForLose());
        } else {
            if (arrayLists != null) {
                if (i < arrayLists.size()) {
                    for (int j = 0; j < arrayLists.get(i).size(); j++) {
                        timeLineDraw();
                        try {
                            if (isAlf) {
                                Gdx.gl.glEnable(GL20.GL_BLEND);
                                Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

                                switch (lvl) {
                                    case 1:
                                    case 2:
                                        arrayLists.get(i).get(j).setAlf();
                                        break;
                                    case 3:
                                        arrayLists.get(i).get(j).setAlf(0.03f);
                                        break;
                                    case 4:
                                        arrayLists.get(i).get(j).setAlf(0.01f);
                                        break;
                                }
                                arrayLists.get(i).get(j).draw();
                                Gdx.gl.glDisable(GL20.GL_BLEND);

                            } else {
                                arrayLists.get(i).get(j).draw();
                            }

                            if (arrayLists.get(i).get(j).getHeightS() < 2) {
                                i++;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        myGame.getBatch().begin();
                        myGame.loader.getFontForCount().draw(myGame.getBatch(), String.valueOf(countOfSquare),
                                Consts.getWIDTH() / 20f, Consts.getHEIGHT() - timeLineH - Consts.getWIDTH() / 20f);
                        myGame.loader.getFontForCountMiss().draw(myGame.getBatch(), String.valueOf(countOfMiss),
                                Consts.getWIDTH() / 20f,
                                Consts.getHEIGHT() - countH - timeLineH - Consts.getWIDTH() / 15f);

                        myGame.getBatch().draw(myGame.loader.getSettingsButton(),
                                Consts.getWIDTH() - rectsS, Consts.getHEIGHT() - rectsS,
                                rectsS, rectsS);

                        myGame.getBatch().end();

                    }
                } else {
                    if (subEv) {
                        Consts.getIsWin().put(lvlName, true);
                        myGame.gsClient.submitEvent(String.valueOf(lvlName), 1);
                        myGame.gsClient.unlockAchievement(Consts.getPRIME());
                    }
                    endLevel(WIN, myGame.loader.getFontForWin());

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
                b[1] = (int) (e[u + 1] * Consts.getScaleY()) + myGame.zero;
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
