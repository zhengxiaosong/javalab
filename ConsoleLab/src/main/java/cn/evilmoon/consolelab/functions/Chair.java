package cn.evilmoon.consolelab.functions;

/**
 * 一个用来观察垃圾收集器的类
 */
public class Chair {
    public static boolean gcrun = false;
    public static boolean flag = false;
    public static int created = 0;
    public static int finalized = 0;
    public static int stopFlag = 10;
    int i;

    public Chair() {
        i = ++created;
        if (created == stopFlag)
            System.out.println("Created " + stopFlag);
    }

    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println(
                    "Beginning to finalize after "
                    + created
                    + " Chairs have been created."
            );
        }

        if (!flag) {
            System.out.println(
                    "Finalizing Chair #" + i +","
                    + ",Setting flag to stop Chair creation"
            );
            flag = true;
        }

        finalized ++;
        if (finalized >= created) {
            System.out.println("All " + finalized + " finalized");
        }
    }
}
