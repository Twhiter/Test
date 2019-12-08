package com.nchu.wiper2.factory;

import com.nchu.wiper2.agent.AbstractAgent;

/**
 * @author T.Whiter
 * @Date 2019/11/20 19:31
 * @Version 1.0
 */
public abstract class AbstractFactory {
    abstract public AbstractAgent getAgent();
}
