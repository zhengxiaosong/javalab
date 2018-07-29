package cn.evilmoon.consolelab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static cn.evilmoon.consolelab.ClassHelper.getAllClassByInterface;

@SuppressWarnings("unchecked")
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
                print(e.getMessage());
            }
        }

        print();
        print(80, "=");
        print("ConsoleLab end!");
    }

    /**
     * 获取当前可执行的试验（Execute注解的时间最晚的一个）
     * @return Lab的实现类，同时被Execute注解的类
     */
    private static Class getRunTarget() {
        ArrayList<Class> labList = getAllClassByInterface(Lab.class,
                Lab.class.getPackage().getName() + ".labs");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date targetTime = new Date();
        targetTime.setTime(0);
        Class targetClass = null;

        for(Class cls : labList) {
            String name = cls.getName();

            if (cls.isAnnotationPresent(TimeTag.class)) {
                TimeTag timeTag = (TimeTag) cls.getAnnotation(TimeTag.class);
                try {
                    Date time = sdf.parse(timeTag.value());
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
