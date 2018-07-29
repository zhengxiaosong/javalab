package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.TimeTag;
import cn.evilmoon.consolelab.Lab;

import java.math.BigDecimal;

/**
 * Java 计算超大数据值示例
 */
@TimeTag("2018-07-29 14:42:34")
public class FigureLab implements Lab {
    @Override
    public void run(String[] args) {
        BigDecimal a = new BigDecimal(1.000000000000000001);
        BigDecimal b = new BigDecimal(1.00000000001234);
        System.out.println(a.add(b));
    }
}
