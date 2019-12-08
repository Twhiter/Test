package com.nchu.wiper2.detector;

import com.nchu.wiper2.randomRain.RandomRain;

/**
 * @author T.Whiter
 * @Date 2019/11/12 17:07
 * @Version 1.0
 */
public class Detector extends AbstractDetector {
    private RandomRain randomRain = new RandomRain();
    public Detector() {
    }

    public Detector(int rainFall) {
        super(rainFall);
    }

    @Override
    public void detectRain() {
        this.setRainFall(randomRain.nextPoisson(0,500));
    }
}
