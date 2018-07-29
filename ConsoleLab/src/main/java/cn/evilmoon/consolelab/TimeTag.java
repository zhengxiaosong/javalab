package cn.evilmoon.consolelab;

import java.lang.annotation.*;

/**
 * 为类指定一个时间标志，Program.main 通过获取该时间，
 * 查找拥有最晚的时间标志的类，然后执行该类
 * 用法，在类名前面标上 ：<br />@TimeTag("yyyy-MM-dd HH:mm")
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TimeTag {
    /**
     * 指定可以开始的执行时间，格式为：yyyy-MM-dd HH:mm
     * @return 时间
     */
    String value();
}
