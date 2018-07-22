package cn.evilmoon;

import org.junit.Test;

/**
 * 测试方法的参数引用
 */
public class ParametersTest {

    @Test
    public void setMainTypeTest() {
        int x = 2;
        setMainType(x);
        assert (x == 2);

        Integer x2 = new Integer(2);
        setMainType(x2);
        assert (x2 == 2);
    }

    @Test
    public void setObjectTypeTest() {
        int x = 2;
        Object obj = x;
        setObjectType(obj);
        int y = (int)obj;

        assert (y == x);
    }

    @Test
    public void setObjectByClassTest() {
        ObjectParam param = new ObjectParam();
        param.x = 2;
        setObjectTypeByClass(param);

        System.out.println("param.x now is " + param.x);
        assert (param.x == 3);
    }

    @Test
    public void setStringTest() {
        String str = new String("this is a charactor has a 'x' value ");
        String newString = setString(str);

        System.out.println("now the string is: " + str);
        System.out.println("And has a new string: " + newString);
        assert (newString != str);
    }

    private void setMainType(int x) {
        x ++;
    }

    private void setMainType(Integer x) {
        x++;
    }

    private void setObjectType (Object obj) {
        int x = (int)obj;
        x++;
        obj = x;
    }

    private void setObjectTypeByClass (ObjectParam param) {
        param.x++;
    }

    private String setString(String str) {
        return str.replace('x', 'y');
    }

    class ObjectParam {
        int x;
    }
}
