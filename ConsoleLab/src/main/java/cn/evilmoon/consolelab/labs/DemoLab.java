package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.TimeTag;
import cn.evilmoon.consolelab.Lab;

@TimeTag("2018-07-27 14:42")
public class DemoLab implements Lab {

    @Override
    public void run(String[] args) {
        System.out.println("Message from DemoLab!");
    }
}
