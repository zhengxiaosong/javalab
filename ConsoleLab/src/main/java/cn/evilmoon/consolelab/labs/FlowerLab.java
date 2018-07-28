package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.functions.Flower;

public class FlowerLab implements Lab {
    @Override
    public void run(String[] args) {
        Flower flower = new Flower();
        flower.print();
    }
}
