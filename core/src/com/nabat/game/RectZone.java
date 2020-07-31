package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RectZone {

    final int HEIGHT_OF_PERIMETER = (int) (10 * Consts.getScaleY());
    final int WIDTH_OF_PERIMETER = (int) (10 * Consts.getScaleX());
    final int PROSAK = (int) (10 * Consts.getScaleXY());
    private final float period = 0.005f;
    private final float DELTA = Gdx.app.getGraphics().getWidth() / 3000f;
    private final int MAX_COUNT_OF_PERIOD_PULSAR = 30;
    int x, y;
    int width;
    int height;
    Color color;
    ShapeRenderer square;
    private int countOfPeriodPulsar = 0;
    private float timeSecondsPulsar = 0f;
    private float gain = 0;
    private boolean pulsar = true;

    public RectZone(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        square = new ShapeRenderer();
        square.setColor(color);

    }

    public void setPulsar(boolean pulsar) {
        this.pulsar = pulsar;
    }

    synchronized public void draw() {

        if (pulsar){

            timeSecondsPulsar += Gdx.graphics.getRawDeltaTime();
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
                countOfPeriodPulsar = 0;
            }

        }



        square.begin(ShapeRenderer.ShapeType.Filled);

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

    boolean isTouch(int X, int Y) {

        return ((x <= X) && (X <= x + width) && (y <= Y) && (Y <= y + height));
    }
    /*boolean isNotOverlay(int X, int Y, int RIGHT, int TOP) {
        return ((x + width < X || RIGHT < x) && (y + height < Y || TOP < y));//
    }*/


}
