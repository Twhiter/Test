package com.nchu.wiper2.washingPump;

/**
 * @author T.Whiter
 * @Date 2019/12/5 14:22
 * @Version 1.0
 */
public class WashingPump extends AbstractWashingPump {
    public WashingPump(int storage, int cost) {
        super(storage, cost);
    }

    public WashingPump() {
    }

    public WashingPump(int storage) {
        super(storage);
    }

    @Override
    public void wash() {
            storage -= cost;
    }
}
