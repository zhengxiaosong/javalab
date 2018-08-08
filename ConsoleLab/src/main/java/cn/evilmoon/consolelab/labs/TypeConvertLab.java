package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 试验类型的转换
 * 主类型的转换，使用 主类型.parseXXX(String)
 * Date类型转换，使用 SimpleDateFormat
 */
@TimeTag("2018-08-08 17:01")
public class TypeConvertLab implements Lab {
    @Override
    public void run(String[] args) {
        String stringData = String.valueOf(48);

        int intData = Integer.parseInt(stringData);
        System.out.println("String to int Integer.parseInt(stringData):\t\t" + intData);

        float floatData = Float.parseFloat(stringData);
        System.out.println("String to float Integer.parseInt(stringData):\t" + floatData);

        try {
            String dateString = "2018-08-08 17:01:01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date dateData = sdf.parse(dateString);
            System.out.println("String to Date use [SimpleDateFormat]:\t\t\t" + sdf.format(dateData));
            System.out.println("\tSimpleDateFormat.format(Date) or SimpleDateFormat.format(String) ");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
