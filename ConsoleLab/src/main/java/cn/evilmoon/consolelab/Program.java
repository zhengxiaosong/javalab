package cn.evilmoon.consolelab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static cn.evilmoon.consolelab.ClassHelper.getAllClassByInterface;

public class Program {
    public static void main(String[] args) {
        print();
        print("ConsoleLab start up:");
        print(80, "=");

        Class targetClass = getRunTarget();
        if (targetClass == null) {
            print("Target Lab: nothing!");
        }
        else {
            print("TimeTag Lab (" + targetClass.getName() + ")");
            print(80, ".");
            print();

            try {
                Lab lab = (Lab)targetClass.newInstance();
                lab.run(args);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        print();
        print(80, "=");
        print("ConsoleLab end!");
    }

    /**
     * 获取当前可执行的试验（TimeTag 注解的时间最晚的一个）
     * @return 实现了 Lab 接口，同时被 TimeTag 注解的类，需要判断是否为 null
     */
    @SuppressWarnings("unchecked")
    private static Class getRunTarget() {

        // 通过包名来获取类所在的相对路径：
        String packagePath = Lab.class.getPackage().getName() + ".labs";
        // 获取路径下所有继承自 Lab 接口的类：
        ArrayList<Class> labList = getAllClassByInterface(Lab.class, packagePath);

        // TimeTag 的时间精确到分钟：
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date targetTime = new Date();
        targetTime.setTime(0);
        Class targetClass = null;

        for(Class cls : labList) {
            // cls 类是否包含 TimeTag 注解：
            if (cls.isAnnotationPresent(TimeTag.class)) {
                // 获取 cls 的 TimeTag 注解对象：
                TimeTag timeTag = (TimeTag) cls.getAnnotation(TimeTag.class);
                try {
                    Date time = dateFormat.parse(timeTag.value());
                    // 记录TimeTag时间最晚的一个类：
                    if (time.after(targetTime)) {
                        targetTime = time;
                        targetClass = cls;
                    }
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return targetClass;
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
     * 打印字符串，通过 noEnter 来指示是否最后加上换行符
     * @param msg 要打印的字符串
     * @param noEnter 是否最后加上换行符
     */
    private static void print(String msg, boolean noEnter) {
        if (noEnter)
            System.out.print(msg);
        else
            print(msg);
    }

    /**
     * 输出一个空白行
     */
    private static void print() {
        System.out.println();
    }
}
