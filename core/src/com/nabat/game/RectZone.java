package com.nabat.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RectZone {

    final int HEIGHT_OF_PERIMETER = (int) (10 * Consts.getScaleY());
    final int WIDTH_OF_PERIMETER = (int) (10 * Consts.getScaleX());
    final int PROSAK = (int) (10 * Consts.getScaleXY());
    int x, y;
    int width;
    int height;
    Color color;
    ShapeRenderer square;

    public RectZone(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        square = new ShapeRenderer();
        square.setColor(color);

    }

    synchronized public void draw() {

        square.begin(ShapeRenderer.ShapeType.Filled);

        square.rect(x, y, width, height); //квадрат
        square.rect(x - WIDTH_OF_PERIMETER - PROSAK,
                y + PROSAK + height,
                width + PROSAK * 2 + WIDTH_OF_PERIMETER * 2,
                HEIGHT_OF_PERIMETER); // верхняя грань
        square.rect(x - WIDTH_OF_PERIMETER - PROSAK,
                y - HEIGHT_OF_PERIMETER - PROSAK,
                width + PROSAK * 2 + WIDTH_OF_PERIMETER * 2,
                HEIGHT_OF_PERIMETER); // нижняя грань
        square.rect(x - PROSAK - WIDTH_OF_PERIMETER,
                y - PROSAK - HEIGHT_OF_PERIMETER,
                WIDTH_OF_PERIMETER,
                height + PROSAK * 2 + HEIGHT_OF_PERIMETER * 2); //левая грань
        square.rect(x + width + PROSAK,
                y - PROSAK - HEIGHT_OF_PERIMETER,
                WIDTH_OF_PERIMETER,
                height + PROSAK * 2 + HEIGHT_OF_PERIMETER * 2); //правая грань
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
