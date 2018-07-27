package cn.evilmoon.consolelab;

import cn.evilmoon.consolelab.labs.DemoLab;

public class Program {
    public static void main(String[] args) {
        printBlank();
        print("ConsoleLab start up:");
        repeatPrint("=", 80);

        Lab lab = new DemoLab();
        lab.run();

        repeatPrint("=", 80);
        print("ConsoleLab end!");
    }

    private static void repeatPrint(String symbol, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    private static void print(String msg) {
        System.out.println(msg);
    }

    private static void printBlank() {
        System.out.println();
    }
}
