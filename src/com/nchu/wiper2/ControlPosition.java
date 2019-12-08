package com.nchu.wiper2;

/**
 * @author T.Whiter
 * @Date 2019/12/2 20:48
 * @Version 1.0
 */
public interface ControlPosition {
    public int getMaxPos(int maxPos);
    public int getPos();
    public void setMaxPos(int maxPos);
    public int upPosition();
    public int downPosition();
}
