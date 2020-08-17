package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class RectZone {

    private final int HEIGHT_OF_PERIMETER = (int) (10 * Consts.getScaleY());
    private final int WIDTH_OF_PERIMETER = (int) (10 * Consts.getScaleX());
    private final int PROSAK = (int) (10 * Consts.getScaleXY());
    private final ShapeRenderer square;
    private final float DELTA = Gdx.app.getGraphics().getWidth() / 3000f;
    private final int width;
    private final int height;
    private final boolean isRotation;
    private final Vector2 leftDown;
    private final float cX = Consts.getWIDTH() / 3f;
    private final float cY = Consts.getHEIGHT() / 2f;
    private boolean pulsar = true;
    private int widthS;
    private int heightS;
    private int x;
    private int xS;
    private int y;
    private int yS;
    private int countOfPeriodPulsar = 0;
    private float timeSecondsPulsar = 0f;
    private float gain = 0;
    private float rot; //deg
    private boolean isDot = false;
    public RectZone(int x, int y, int width, int height, Color color, boolean isRotation, float rot, boolean isDot) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isRotation = isRotation;
        this.rot = rot;
        this.isDot = isDot;

        /*if (isDot){
            DELTA = height/15f;
        }*/
        square = new ShapeRenderer();
        square.setColor(color);

        leftDown = new Vector2(x - cX, y - cY);
        /*leftUp = new Vector2(x, y + height);
        rightDown = new Vector2(x + width,y);
        rightUp = new Vector2(x + width,y+height);*/
    }

    public RectZone(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isRotation = false;

        square = new ShapeRenderer();
        square.setColor(color);

        leftDown = new Vector2(x, y);
        /*leftUp = new Vector2(x, y + height);
        rightDown = new Vector2(x + width,y);
        rightUp = new Vector2(x + width,y+height);*/

    }

    public void setPulsar(boolean pulsar) {
        this.pulsar = pulsar;
    }

    public int getHeightS() {
        return heightS;
    }

    /*public void setRotation(boolean rotation, float rot) {
        this.rot = rot;
        isRotation = rotation;

        cX = x + width / 4f;
        cY = y + height / 4f;
        leftDown = new Vector2(x - cX, y - cY);
    }*/

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    synchronized public void draw() {


        if (pulsar) {

            timeSecondsPulsar += Gdx.graphics.getRawDeltaTime();
            float period = 0.005f;
            int MAX_COUNT_OF_PERIOD_PULSAR = 30;

            if (isDot) {

                if (timeSecondsPulsar > period) {


                    gain -= DELTA;

                    timeSecondsPulsar -= period;

                }
            } else {

                if (countOfPeriodPulsar <= MAX_COUNT_OF_PERIOD_PULSAR / 2) {


                    if (timeSecondsPulsar > period) {


                        gain += DELTA;

                        timeSecondsPulsar -= period;
                        countOfPeriodPulsar++;
                    }

                } else if (countOfPeriodPulsar < MAX_COUNT_OF_PERIOD_PULSAR) {

                    if (timeSecondsPulsar > period) {


                        gain -= DELTA;

                        timeSecondsPulsar -= period;
                        countOfPeriodPulsar++;
                    }

                } else if (countOfPeriodPulsar == MAX_COUNT_OF_PERIOD_PULSAR) {

                    //gain = 0;
                    gain -= DELTA * 2;
                    countOfPeriodPulsar = 0;
                }
            }


        }


        square.begin(ShapeRenderer.ShapeType.Filled);


        if (isRotation) {

            leftDown.rotate(rot);

            x = (int) (leftDown.x + cX);
            y = (int) (leftDown.y + cY);
        }

        xS = (int) (x - gain);
        yS = (int) (y - gain);
        widthS = (int) (width + gain * 2);
        heightS = (int) (height + gain * 2);

        square.rect(x - gain, y - gain,
                width + gain * 2, height + gain * 2); //квадрат

        square.rect((x - WIDTH_OF_PERIMETER - PROSAK) - gain,
                y + PROSAK + height + gain,
                width + PROSAK * 2 + WIDTH_OF_PERIMETER * 2 + gain * 2,
                HEIGHT_OF_PERIMETER); // верхняя грань

        square.rect(x - WIDTH_OF_PERIMETER - PROSAK - gain,
                y - HEIGHT_OF_PERIMETER - PROSAK - gain,
                width + PROSAK * 2 + WIDTH_OF_PERIMETER * 2 + gain * 2,
                HEIGHT_OF_PERIMETER); // нижняя грань

        square.rect(x - PROSAK - WIDTH_OF_PERIMETER - gain,
                y - PROSAK - HEIGHT_OF_PERIMETER - gain,
                WIDTH_OF_PERIMETER,
                height + PROSAK * 2 + HEIGHT_OF_PERIMETER * 2 + gain * 2); //левая грань

        square.rect(x + width + PROSAK + gain,
                y - PROSAK - HEIGHT_OF_PERIMETER - gain,
                WIDTH_OF_PERIMETER,
                height + PROSAK * 2 + HEIGHT_OF_PERIMETER * 2 + gain * 2); //правая грань

        square.end();
    }

    public void dispose() {
        square.dispose();
    }
    /*boolean isNotOverlay(int X, int Y, int RIGHT, int TOP) {
        return ((x + width < X || RIGHT < x) && (y + height < Y || TOP < y));//
    }*/

    public boolean isTouch(int X, int Y) {

        return ((xS <= X) && (X <= xS + widthS) && (yS <= Y) && (Y <= yS + heightS));
    }
}
