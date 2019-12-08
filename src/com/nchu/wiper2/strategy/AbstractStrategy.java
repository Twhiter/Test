package com.nchu.wiper2.strategy;

/**
 * @author T.Whiter
 * @Date 2019/11/22 19:44
 * @Version 1.0
 */
abstract public class AbstractStrategy {


    public AbstractStrategy() {

    }


    abstract public int decideDialPos(int rainFall);
    abstract public int decideLeverPos(int rainFall);
}
