package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class RectZone {

    private final int HEIGHT_OF_PERIMETER = (int) (10 * Consts.getScaleY());
    private final int WIDTH_OF_PERIMETER = (int) (10 * Consts.getScaleX());
    private final int PROSAK = (int) (10 * Consts.getScaleXY());
    private final float DELTA = Gdx.app.getGraphics().getWidth() / 3000f;
    private final boolean isTranspos;
    private final Vector2 leftDown;
    private int x;
    private int y;
    private final int width;
    private final int height;
    private final ShapeRenderer square;
    private int countOfPeriodPulsar = 0;
    private float timeSecondsPulsar = 0f;
    private float gain = 0;
    private boolean pulsar = true;
    private float rot; //deg

    public RectZone(int x, int y, int width, int height, Color color, boolean isTranspos, float rot) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isTranspos = isTranspos;
        this.rot = rot;

        square = new ShapeRenderer();
        square.setColor(color);

        leftDown = new Vector2(x - Consts.getWIDTH() / 2f, y - Consts.getHEIGHT() / 2f);
        /*leftUp = new Vector2(x, y + height);
        rightDown = new Vector2(x + width,y);
        rightUp = new Vector2(x + width,y+height);*/
    }

    public RectZone(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isTranspos = false;

        square = new ShapeRenderer();
        square.setColor(color);

        leftDown = new Vector2(x, y);
        /*leftUp = new Vector2(x, y + height);
        rightDown = new Vector2(x + width,y);
        rightUp = new Vector2(x + width,y+height);*/

    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPulsar(boolean pulsar) {
        this.pulsar = pulsar;
    }

    synchronized public void draw() {


        if (pulsar) {

            timeSecondsPulsar += Gdx.graphics.getRawDeltaTime();
            float period = 0.005f;
            int MAX_COUNT_OF_PERIOD_PULSAR = 30;
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


        square.begin(ShapeRenderer.ShapeType.Filled);


        if (isTranspos) {

            leftDown.rotate(rot);

            x = (int) (leftDown.x + Consts.getWIDTH() / 2f);
            y = (int) (leftDown.y + Consts.getHEIGHT() / 2f);
        }


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

        return ((x <= X) && (X <= x + width) && (y <= Y) && (Y <= y + height));
    }
}
