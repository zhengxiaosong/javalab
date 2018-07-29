package cn.evilmoon.consolelab;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TimeTag {
    /**
     * 指定可以开始的执行时间，格式为：yyyy-MM-dd HH:mm:ss
     * @return 时间
     */
    String value();
}
