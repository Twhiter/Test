package com.nchu.wiper2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author T.Whiter
 * @Date 2019/12/5 15:00
 * @Version 1.0
 */
public class Record {
    private ArrayList<String> data = new ArrayList<>();

    public Record() {

    }

    public void writeIntoFile(String pathName)   {
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter(new File(pathName));

            for (String record : data)
                printWriter.println(record);

            printWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addData(String newData) {
        data.add(newData);
    }
}
