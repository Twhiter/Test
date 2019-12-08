package com.nchu.wiper2.factory;

import com.nchu.wiper2.agent.AbstractAgent;
import com.nchu.wiper2.agent.AutoAgent;
import com.nchu.wiper2.brush.Brush;
import com.nchu.wiper2.dial.Dial;
import com.nchu.wiper2.lever.Lever;
import com.nchu.wiper2.xml.XMLUtil;

import java.util.Objects;

/**
 * @author T.Whiter
 * @Date 2019/11/20 19:37
 * @Version 1.0
 */
public class FactoryAutoAgent extends AbstractFactory {
    @Override
    public AbstractAgent getAgent() {
        try {

            Brush brush = (Brush) Objects.requireNonNull(XMLUtil.getBean("BrushName","factoryConfig.tld")).newInstance();
            Lever lever = (Lever) Objects.requireNonNull(XMLUtil.getBean("LeverName","factoryConfig.tld")).newInstance();
            Dial dial = (Dial) Objects.requireNonNull(XMLUtil.getBean("DialName","factoryConfig.tld")).newInstance();

            lever.setMaxPos(4);
            dial.setMaxPos(4);

            return new AutoAgent(lever,dial,brush);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }
}
