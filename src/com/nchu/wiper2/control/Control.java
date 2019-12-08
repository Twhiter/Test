package com.nchu.wiper2.control;

import com.nchu.wiper2.GameFunctions;
import com.nchu.wiper2.Record;
import com.nchu.wiper2.Status;
import com.nchu.wiper2.agent.AbstractAgent;
import com.nchu.wiper2.agent.AutoMove;
import com.nchu.wiper2.detector.AbstractDetector;
import com.nchu.wiper2.strategy.AbstractStrategy;
import com.nchu.wiper2.washingPump.AbstractWashingPump;

import java.util.Calendar;

/**
 * @author T.Whiter
 * @Date 2019/12/5 14:32
 * @Version 1.0
 */
public class Control extends AbstractControl implements RainDeal,WashingDeal {

    private static int timeCount = 0;

    public Control() {
    }

    public Control(AbstractDetector detector, AbstractWashingPump washingPump, AbstractAgent agent, AbstractStrategy strategy) {
        super(detector, washingPump, agent, strategy);
    }



    @Override
    public void work()  {

        Record record = new Record();

        Status status = Status.Raining;

        //洗涤时间和结束时间
        int washingTime = 0;
        int endTime = 0;

        //记录数据的数量
        int cnt = 0;


        //进行30次数据获取
        for (int i = 0; cnt <= 30; i++) {
            if (GameFunctions.isWasherReady() && status != Status.Washing){
                status = Status.Washing;
                washingTime = 0;
            }

            if (status == Status.Raining) {
                if (i % 10 == 0) {
                    cnt ++;
                    record.addData(detector.getRainFall() + "," + agent.getSpeed());
                    detector.detectRain();
                }
                rainDeal();
            }
            else {
                if (washingTime == 0) {

                    endTime = GameFunctions.brushTimes() * 3 + 3;

                    if (washingPump.isInsufficient())
                        washingPump.wash();
                    else {
                        record.addData("Warning: Washer fluid Insufficient");
                        status = Status.Raining;
                    }
                }
                else if (washingTime >= 3 && washingTime <= endTime)
                    washingDeal();
                else {
                    record.addData(String.format("Cleaning Windshield %d seconds",endTime));
                    status = Status.Raining;
                }
                washingTime ++;
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        record.writeIntoFile("out.txt");

    }

    @Override
    public void washingDeal() {

        ((AutoMove) agent).moveTo(1,0);
        agent.dealSpeed();
    }

    @Override
    public void rainDeal() {

        int nextDialPos = strategy.decideDialPos(detector.getRainFall());
        int nextLeverPos = strategy.decideLeverPos(detector.getRainFall());

        ((AutoMove) agent).moveTo(nextLeverPos,nextDialPos);
        agent.dealSpeed();
    }


}
