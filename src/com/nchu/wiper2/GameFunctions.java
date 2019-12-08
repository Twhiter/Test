package com.nchu.wiper2;

import java.util.Random;

/**
 * @author T.Whiter
 * @Date 2019/12/5 15:40
 * @Version 1.0
 */


public class GameFunctions {

    /***
     * 模拟是否打开洗涤器
     * @return 是否打开洗涤器
     */
    static public boolean isWasherReady() {
        return Math.random() <= 1.0 * 4 / 300;
    }

    /***
     * 模拟洗涤器洗完后要雨刷摆动的次数
     * @return 雨刷摆动的次数
     */
    static public int brushTimes() {
        return new Random().nextInt(2) + 3;
    }
}
