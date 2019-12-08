package com.nchu.wiper2.strategy;

/**
 * @author T.Whiter
 * @Date 2019/11/22 19:51
 * @Version 1.0
 */
public class Strategy extends AbstractStrategy {

    public Strategy() {
        super();
    }

    /***
     * 根据雨量计算出刻度盘要移动到的刻度
     *  1-80    81-160   161-240     241-320   else
     *  1          2        3           4       X
     * @param  rainFall 当前雨量
     * @return  刻度盘要移动到的刻度
     */
    @Override
    public int decideDialPos(int rainFall) {
       if (rainFall >=1 && rainFall <= 80)
           return 1;
       else if (rainFall >=81 && rainFall <= 160 )
           return 2;
       else if (rainFall >= 161 && rainFall <= 240)
           return 3;
       else if (rainFall >= 241 && rainFall <= 320)
           return 4;
       else
           return 0;
    }

    /***
     *
     * 根据雨量选择控制杆刻度
     * 0    1-320   321-400     401-450     451-500
     * 0      1         2           3           4
     * @param rainFall 当前雨量
     * @return 控制杠要移动到的位置
     */

    @Override
    public int decideLeverPos(int rainFall) {
        if (rainFall == 0)
            return 0;
        else if (rainFall >= 1 && rainFall <= 320)
            return 1;
        else if (rainFall >= 321 && rainFall <= 400)
            return 2;
        else if (rainFall >= 401 && rainFall <= 450)
            return 3;
        else
            return 4;
    }

}
