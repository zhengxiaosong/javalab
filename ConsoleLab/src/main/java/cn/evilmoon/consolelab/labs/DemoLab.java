package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;

public class DemoLab implements Lab {
    @Override
    public void run(String[] args) {
        System.out.println("Message from DemoLab!");
    }
}
