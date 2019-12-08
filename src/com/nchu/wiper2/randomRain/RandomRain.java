package com.nchu.wiper2.randomRain;

import java.util.Random;

/**
 * @author T.Whiter
 * @Date 2019/11/7 12:13
 * @Version 1.0
 */
public class RandomRain {

    private Random random = new Random();
    public RandomRain() {
    }

    /**
     * @param lRange 左范围
     * @param rRange 右范围
     * @return 位于区间[lRange,rRange]之间符合正态分布的随机数
     * @see Random#nextGaussian()
     *
     * 设 X为高斯函数N(0,1)的变量,利用Y = aX + b将 N(0,1)变为 N[(rRange - lRange) / 2.0,((rRange - lRange) / 6.0)^2]
     */
    public int nextGaussian(int lRange, int rRange) {
        int result = -1;
        while (result > rRange || result < lRange) {
            result  = (int) (random.nextGaussian() * (rRange - lRange) / 6.0+ (rRange - lRange) / 2.0);
        }
        return result;
    }

    /**
     *
     * @param lRange 左范围
     * @param rRange 右范围
     * @return 位于区间[lRange,rRange]之间符合泊松的随机数,且均值为(lRange + rRange) / 2
     */
    public int nextPoisson(int lRange,int rRange) {
        int u = (lRange + rRange) / 2;
        double l = Math.exp(-1 * u);
        int k = 0;
        double p = 1;

        do {
            k ++;
            p *= random.nextDouble();
        }
        while (p > l);
        return k - 1;
    }
}
