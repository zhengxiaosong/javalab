package cn.evilmoon;

import cn.evilmoon.TestModels.StaticTestModel;
import org.junit.Test;

/**
 * 测试静态类
 */
public class StaticTest {

    /**
     * 类的静态成员可以使用类实例来引用
     */
    @Test
    public void staticIntValueText () {
        StaticTestModel mdl = new StaticTestModel();
        assert (mdl.iValue == StaticTestModel.iValue);
    }
}
