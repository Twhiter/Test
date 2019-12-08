package com.nchu.wiper2.agent;

import com.nchu.wiper2.brush.Brush;
import com.nchu.wiper2.dial.Dial;
import com.nchu.wiper2.lever.Lever;

/**
 * @author T.Whiter
 * @Date 2019/11/7 17:02
 * @Version 1.0
 */
public class AutoAgent extends AbstractAgent implements AutoMove {

    AutoAgent() {

    }

    public AutoAgent(Lever lever, Dial dial, Brush brush) {
        super(brush,dial, lever);
    }





    /**
     *
     *  将控制杠和刻度表移动到相应位置
     * @param leverPos 控制杠要移动到的位置
     * @param dialPos  刻度表要移动到的位置
     */

    @Override
    public void moveTo(int leverPos,int dialPos) {
        try {

            //对刻度表进行移动
            while (dialPos != dial.getPos()) {
                if (dial.getPos() < dialPos)
                    dial.upPosition();
                else dial.downPosition();
                Thread.sleep(100);
            }

            //对控制杠进行移动
            while (lever.getPos() != leverPos) {
                if (lever.getPos() < leverPos)
                    lever.upPosition();
                else lever.downPosition();
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     *根据刻度表和控制杠挡位设置速度
     *      LeverPos:    0   1   1   1   1     2   3  4
     *      DialPos:     0   1   2   3   4     X   X  X
     *      Speed:       0   4   6   12  20    30  60 90
     */
    public void dealSpeed() {
        switch (lever.getPos()) {
            case 0:this.setSpeed(0);break;
            case 1:
                switch (this.dial.getPos()) {
                    case 1:this.setSpeed(4);break;
                    case 2:this.setSpeed(6);break;
                    case 3:this.setSpeed(12);break;
                    case 4:this.setSpeed(20);
                }
                break;
            case 2:setSpeed(30);break;
            case 3:setSpeed(60);break;
            case 4:setSpeed(90);break;
            default:
        }
    }


    @Override
    public void show() {
    }
}
