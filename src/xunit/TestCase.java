package xunit;

import java.lang.reflect.Method;

public class TestCase implements Test{
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public TestResult run(TestResult testResult) {
        testResult.testStarted();
        setUp();
        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (Exception e) {
            testResult.testFaild();
        }
        
        tearDown();
        return testResult;
    }

    public void tearDown() {
    }

    public void setUp() {

    }
}
