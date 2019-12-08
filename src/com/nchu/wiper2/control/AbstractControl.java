package com.nchu.wiper2.control;

import com.nchu.wiper2.agent.AbstractAgent;
import com.nchu.wiper2.detector.AbstractDetector;
import com.nchu.wiper2.strategy.AbstractStrategy;
import com.nchu.wiper2.washingPump.AbstractWashingPump;

/**
 * @author T.Whiter
 * @Date 2019/12/5 14:08
 * @Version 1.0
 */
abstract public class AbstractControl {

    protected AbstractDetector detector;
    protected AbstractWashingPump washingPump;
    protected AbstractStrategy strategy;
    protected AbstractAgent agent;

    public AbstractControl() {

    }


    public AbstractControl(AbstractDetector detector, AbstractWashingPump washingPump
            ,AbstractAgent agent,AbstractStrategy strategy) {

        this.detector = detector;
        this.washingPump = washingPump;
        this.strategy = strategy;
        this.agent = agent;
    }

    public AbstractControl(AbstractDetector detector,AbstractWashingPump washingPump,AbstractAgent agent) {
        this.detector = detector;
        this.washingPump = washingPump;
        this.agent = agent;
    }

    /***
     * 整个雨刷系统工作的方式
     */
    abstract public void work();



}
