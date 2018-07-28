package cn.evilmoon.consolelab;

import cn.evilmoon.consolelab.labs.FlowerLab;
import cn.evilmoon.consolelab.labs.GarbageLab;
import cn.evilmoon.consolelab.labs.InitializeLab;

public class Program {
    public static void main(String[] args) {
        print();
        print("ConsoleLab start up:");
        print(80, "=");

        Lab lab = new InitializeLab();
        lab.run(args);

        print(80, "=");
        print("ConsoleLab end!");
    }

    /**
     * 重复打印字符串
     * @param times 重复次数
     * @param symbol 要打印的字符串
     */
    private static void print(int times, String symbol) {
        for (int i = 0; i < times; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    /**
     * 打印字符串
     * @param msg 要打印的字符串
     */
    private static void print(String msg) {
        System.out.println(msg);
    }

    /**
     * 输出一个空白行
     */
    private static void print() {
        System.out.println();
    }
}
