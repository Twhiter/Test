package com.nchu.wiper2.washingPump;

/**
 * @author T.Whiter
 * @Date 2019/12/5 14:11
 * @Version 1.0
 */
abstract public class AbstractWashingPump {
    protected int storage;
    protected int cost;

    public AbstractWashingPump(int storage,int cost) {
        this.storage = storage;
        this.cost = cost;
    }

    public AbstractWashingPump() {

    }

    public AbstractWashingPump(int storage) {
        this.storage = storage;
        this.cost = 1;
    }

    abstract public void wash();



    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getStorage() {
        return storage;
    }

    public boolean isInsufficient() {
        return storage >= cost;
    }
}
