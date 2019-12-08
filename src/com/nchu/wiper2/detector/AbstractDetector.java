package com.nchu.wiper2.detector;

/**
 * @author T.Whiter
 * @Date 2019/11/12 17:05
 * @Version 1.0
 */
abstract public class AbstractDetector {
    private int rainFall;

    public AbstractDetector() {
    }

    public AbstractDetector(int rainFall) {
        this.rainFall = rainFall;
    }

    public int getRainFall() {
        return rainFall;
    }

    public void setRainFall(int rainFall) {
        this.rainFall = rainFall;
    }

    abstract public void detectRain();
}
