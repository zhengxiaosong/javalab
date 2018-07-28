package cn.evilmoon.consolelab.functions;

/**
 * 一个用于学习 this 用法的类
 * 尝试构造器里调用自身的其他构造器
 */
public class Flower {
    private int petalCount = 0; // 花瓣的数量
    private String s = new String("null");

    /**
     * 指定花瓣的数量来构造一个Flower类
     * @param petals 花瓣的数量
     */
    public Flower(int petals) {
        petalCount = petals;
        System.out.println(
                "Constructor w/ int arg only, petalCount="
                + petalCount);
    }

    /**
     * 通过输入一个字符串来构造 Flower 类
     * @param ss
     */
    public Flower(String ss) {
        System.out.println("Constructor w/ String arg only, s=" + ss);
        s = ss;
    }

    /**
     * 通过输入一个字符串及指定花瓣数量来构造 Flower
     * @param s
     * @param petals
     */
    public Flower(String s, int petals) {
        // 可以使用 this 来调用其他构造器，
        // 但是只能使用一个，而不能使用多个
        this(petals);
        this.s = s;
        System.out.println("String & int args");
    }

    /**
     * 默认的构造器
     */
    public Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    /**
     * 输出信息
     */
    public void print() {
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }
}
