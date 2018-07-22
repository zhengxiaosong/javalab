package cn.evilmoon;

import cn.evilmoon.Labs.Demo;

public class Application {
    public static void main(String[] args) {
        System.out.println("\nApplication(JavaLab) startup!");
        RepeatShow("=", 80);

        // 执行试验实例：
        Experiment exp = new Demo();
        exp.execute();

        RepeatShow("=", 80);
        System.out.println("Application(JavaLab) stop!");
    }

    /*
     * 循环显示 symbol 字符串
     */
    private static void RepeatShow(String symbol, Integer times) {
        for(Integer i = 0; i < times; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
