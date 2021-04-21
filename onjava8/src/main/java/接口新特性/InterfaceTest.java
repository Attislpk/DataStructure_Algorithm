package 接口新特性;

import org.junit.Test;

public class InterfaceTest {

    @Test
    public void test() {
        DefaultMethodTest defaultMethodTest = new DefaultMethodTest();
        defaultMethodTest.show();
        defaultMethodTest.defaulMethod();
        DefaultMethod.staticMethod();
    }

}
