package cn.evilmoon;

import org.junit.Test;

/**
 * 逻辑判断的短路测试
 */
public class ShortCircuitTest {

    /**
     * 测试值 val 是否小于 1
     * @param val int
     * @return boolean
     */
    private boolean test1(int val) {
        System.out.print("test1(" + val + ") ");
        System.out.println("Result: " + (val < 1));
        return val < 1;
    }

    /**
     * 测试值 val 是否小于 2
     * @param val int
     * @return boolean
     */
    private boolean test2(int val) {
        System.out.print("test2(" + val + ") ");
        System.out.println("Result: " + (val < 2));
        return val < 2;
    }

    /**
     * 测试值 val 是否小于 3
     * @param val int
     * @return boolean
     */
    private boolean test3(int val) {
        System.out.print("test3(" + val + ") ");
        System.out.println("Result:" + (val < 3));
        return val < 3;
    }

    /**
     * 使用 test1、test2、test3 方法测试 if 语句的逻辑短路
     */
    @Test
    public void test() {
        // 从左往右，当有表达式为 false 时，if 语句将被中断，后面当表达式将不被计算
        if (test1(0) && test2(2) && test3(3)) {
            System.out.println("expression is true");
        }
        else {
            System.out.println("expression is false");
        }
    }
}
