package com.nabat.game;

public class Str {
    int x;
    int y;
    float h;
    float wP;
    String title, check, per;
    MyGame myGame;

    public Str(int x, int y, float h, float w, String title, String check, String per, MyGame myGame) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.wP = w;
        this.title = title;
        this.check = check;
        this.per = per;
        this.myGame = myGame;
    }

    public float getH() {
        return h;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw() {
        Consts.getFontForBoards().draw(myGame.getBatch(), title, x, y);

        Consts.getFontForBoards().draw(myGame.getBatch(), check,
                x + Consts.getWIDTH() / 2f, y);

        Consts.getFontForBoards().draw(myGame.getBatch(), per,
                wP, y);
    }


}
