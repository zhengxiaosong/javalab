package cn.evilmoon;

import org.junit.Test;

/**
 * 测试Java的 == 和 != 符号
 *
 * 发现Java重载了 String 的 == 和 != 符号，
 * 却没有重载 Integer 等数值类型的 == 和 != 符号，变态。
 */
public class BooleanTest {
    /**
     * n1、n2 是 Integer 对象，使用 == 和 != 只能比较句柄
     */
    @Test
    public void integerEqualTest() {
        System.out.println("From integerEqualTest ==========");
        System.out.println("Test Integer:");
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2); // print false;
        System.out.println(n1 != n2);   // print true
        System.out.println(n1.intValue() == n2.intValue());
        System.out.println("Test int:");
        int i1 = 47;
        int i2 = 47;
        System.out.println(i1 == i2);
    }

    @Test
    public void stringEqualTest() {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println("From stringEqualTest ==========");
        System.out.println(str1 == str2); // print true
    }
}
