package com.tanyin.wordpuzzle;

/**
 * Created by tanyin on 2017/1/7.
 */
public class Step {
    public final static int RIGHT = 0;
    public final static int UP_RIGHT = 1;
    public final static int UP = 2;
    public final static int UP_LEFT = 3;
    public final static int LEFT = 4;
    public final static int DOWN_LEFT = 5;
    public final static int DOWN = 6;
    public final static int DOWN_RIGHT = 7;
    private int x;
    private int y;
    private int dir;

    public int getX() {
        return x;
    }

    public Step(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }
}
