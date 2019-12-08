package com.nchu.wiper2.agent;

import com.nchu.wiper2.brush.Brush;
import com.nchu.wiper2.dial.Dial;
import com.nchu.wiper2.lever.Lever;

/**
 * @Author T.Whiter
 * @Date 2019/11/6 20:54
 * @Version 1.0
 */
public class Agent extends AbstractAgent {


    public Agent(Brush brush, Dial dial, Lever lever) {
        super(brush, dial, lever);
    }

    public Agent() {

    }

    @Override
    /**
     *根据刻度表和控制杠挡位设置速度
     *      LeverPos:    0   1   1   1   2   3
     *      DialPos:     0   1   2   3   X   X
     *      Speed:       0   4   6   12  30  60
     */
    public void dealSpeed() {
        switch (lever.getPos()) {
            case 0:this.setSpeed(0);break;
            case 1:
                switch (this.dial.getPos()) {
                    case 1:this.setSpeed(4);break;
                    case 2:this.setSpeed(6);break;
                    case 3:this.setSpeed(12);break;
                }
                break;
            case 2:setSpeed(30);break;
            case 3:setSpeed(60);break;
            default:
                System.exit(-1);
        }
    }

    @Override
    public void show() {

    }

}
