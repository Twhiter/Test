package com.nchu.wiper2.factory;

import com.nchu.wiper2.agent.AbstractAgent;
import com.nchu.wiper2.agent.Agent;
import com.nchu.wiper2.brush.Brush;
import com.nchu.wiper2.dial.Dial;
import com.nchu.wiper2.lever.Lever;

/**
 * @author T.Whiter
 * @Date 2019/11/20 19:32
 * @Version 1.0
 */
public class FactoryAgent extends AbstractFactory {
    @Override
    public AbstractAgent getAgent() {
        Dial dial = new Dial(3);
        Brush brush = new Brush();
        Lever lever = new Lever(3);

        return new Agent(brush, dial,lever);
    }
}
