package cn.evilmoon;

import org.junit.Test;

import java.util.Date;
import java.util.Properties;

/*
 * 获取系统的信息
 */
public class SystemMessageTest {
    @Test
    public void showSystemMessageTest() {
        System.out.println(new Date());

        Properties properties = System.getProperties();
        properties.list(System.out);

        System.out.println("---- Memory Usage: ");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = "
            + rt.totalMemory()
            + " Free Memory = "
            + rt.freeMemory());
    }
}
