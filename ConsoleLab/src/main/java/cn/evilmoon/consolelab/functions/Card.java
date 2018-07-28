package cn.evilmoon.consolelab.functions;

/**
 * 一个用来观察类成员被初始化的次序的类
 */
public class Card {
    Tag t1 = new Tag(1);    // 构造器之前被初始化
    public Card() {
        System.out.println("Card()");
        t3 = new Tag(33);   // 被初始化两次
    }

    Tag t2 = new Tag(2);
    public void f() {
        System.out.println("f()");
    }

    Tag t3 = new Tag(3);

    class Tag {
        Tag(int marker) {
            System.out.println("Tag(" + marker + ")");
        }
    }
}
