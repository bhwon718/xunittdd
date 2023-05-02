package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public TestReslt run() {

        TestReslt testReslt = new TestReslt();
        testReslt.testStarted();

        setUp();
        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        
        tearDown();
        return testReslt;
    }

    public void tearDown() {
    }

    public void setUp() {

    }
}
