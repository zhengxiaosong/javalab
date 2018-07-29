package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.TimeTag;
import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.functions.Card;

/**
 * 观察类成员初始化次序的试验：先按定义的次序初始化，再调用构造器的初始化
 */
@TimeTag("2018-07-29 17:11")
public class InitializeLab implements Lab {
    @Override
    public void run(String[] args) {
        Card card = new Card();
        card.f();
    }
}
