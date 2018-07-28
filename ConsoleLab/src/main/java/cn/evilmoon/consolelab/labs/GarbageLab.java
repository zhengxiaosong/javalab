package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.functions.Chair;

/**
 * 观察垃圾收集器的试验，使用了 functions.Chair 类
 */
public class GarbageLab implements Lab {

    /**
     * 本例子需要指定一个输入参数
     * @param args 接收一个字符串参数：before 或者 after
     */
    @Override
    public void run(String[] args) {
        if (args.length == 0) {
            System.err.println(
                    "Usage: \n"
                    + "java Garbage before\n or:\n"
                    + "java Garbage after"
            );
            return;
        }

        while (!Chair.flag) {
            new Chair();
            new String("To take up space");
        }

        System.out.println(
                "After all Chairs have been created:\n"
                        + "total created = "
                        + Chair.created
                        + ", total finalized = "
                        + Chair.finalized
        );

        if (args[0].equals("before")) {
            System.out.println("gc():");
            System.gc();
            System.out.println("runFinalizations():");
            System.runFinalization();
        }

        System.out.println("Bye!");

        if (args[0].equals("after")) {
            System.runFinalizersOnExit(true);
        }
    }
}
