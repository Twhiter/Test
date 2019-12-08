package com.nchu.wiper2.lever;

import com.nchu.wiper2.ControlPosition;

/**
 * @author T.Whiter
 * @Date 2019/11/7 16:40
 * @Version 1.0
 */
public class Lever implements ControlPosition {

    private int maxPos;
    private int pos;

    public Lever(int maxPos) {
        this.maxPos = maxPos;
    }

    public Lever() {

    }

    @Override
    public int getMaxPos(int maxPos) {
        return maxPos;
    }

    @Override
    public int getPos() {
        return pos;
    }

    @Override
    public void setMaxPos(int maxPos) {
        this.maxPos = maxPos;
    }

    @Override
    public int upPosition() {
        if (pos < maxPos)
            pos ++;
        return pos;
    }

    @Override
    public int downPosition() {
        if (pos > 0)
            pos --;
        return pos;
    }
}
