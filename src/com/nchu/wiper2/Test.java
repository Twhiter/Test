package com.nchu.wiper2;

import com.nchu.wiper2.control.Control;
import com.nchu.wiper2.detector.Detector;
import com.nchu.wiper2.factory.AbstractFactory;
import com.nchu.wiper2.factory.FactoryAutoAgent;
import com.nchu.wiper2.strategy.Strategy;
import com.nchu.wiper2.washingPump.WashingPump;

/**
 * @Author T.Whiter
 * @Date 2019/11/6 20:43
 * @Version 1.0
 */



public class Test {

    public static void main(String[] args) {

        AbstractFactory factory = new FactoryAutoAgent();

        Control control = new Control(new Detector(),new WashingPump(4,1),factory.getAgent(),new Strategy());
        control.work();

    }
}

