package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;
import cn.evilmoon.consolelab.functions.Flower;

/**
 * 一个用于学习 this 用法的类, 尝试构造器里调用自身的其他构造器
 * 使用了 functions.Flower 类
 */
@TimeTag("2018-07-29 19:40")
public class FlowerLab implements Lab {
    @Override
    public void run(String[] args) {
        Flower flower = new Flower();
        flower.print();
    }
}
