package com.nabat.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class RectZone extends Actor {

    final int HEIGHT_OF_PERIMETER = 10;
    final int WIDTH_OF_PERIMETER = 10;
    final int PROSAK = 10;
    int x, y;
    int width;
    int height;
    Color color;
    ShapeRenderer square;
//    ShapeRenderer perimeter;

    public RectZone(int x, int y, int width, int height, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        square = new ShapeRenderer();


        square.setColor(color);
//        perimeter = new ShapeRenderer();

    }

    public void draw() {
        square.begin(ShapeRenderer.ShapeType.Filled);

//width
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

//        perimeter.rect(x,y,right, bottom);


        square.end();
//        perimeter.end();
    }

    public void dispose(){
        square.dispose();
    }

    boolean isTouch(int X, int Y) {

        return ((x <= X) && (X <= x + width) && (y <= Y) && (Y <= y + height));
    }
    boolean isNotOverlay(int X, int Y, int RIGHT, int TOP) {
        return ((x + width < X || RIGHT < x) && (y + height < Y || TOP < y));//
    }


/*

    public RectZone(int X, int Y, int right, int bottom, int color) {

        this.x = X;
        this.y = Y;
        this.right = right;
        this.bottom = bottom;
        this.color = color;


    }

    public void rectDraw(Canvas c) {

        c.drawRect(x, y, right, bottom, paint);
        c.drawRect(x-10, y-10, right+10, bottom+10, paint2);

    }

    boolean isTouch(int X, int Y) {

        return (x <= X) && (X <= right) && (y <= Y) && (Y <= bottom);
    }
    boolean isTouch(float X, float Y) {

        return (x <= X) && (X <= right) && (y <= Y) && (Y <= bottom);
    }

    boolean isNotOverlay(int X, int Y, int RIGHT, int BOTTOM) {
        return ((right < X || RIGHT < x) && (bottom < Y || BOTTOM < y));//
    }
*//*
*
* (x<X)&&(y<Y)&&(RIGHT<right)&&(BOTTOM<bottom))
                ||((X<x)&&(Y<y)&&(right<RIGHT)&&(bottom<BOTTOM)
* *//*
     */
}
