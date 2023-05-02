package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    public void testResult(){
        WasRun wasRun = new WasRun("testMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("1 run, 0 failed", testResult.Summary());
    }

    public void testFaildResultFormatting(){
        TestResult testResult = new TestResult();
        testResult.testStarted();
        testResult.testFaild();
        Assert.assertEquals("1 run, 1 failed", testResult.Summary());
    }

    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("1 run, 1 failed", testResult.Summary());
    }

    public void testSuite(){
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        TestResult testResult = new TestResult();
        suite.run(testResult);
        Assert.assertEquals("2 run, 1 failed", testResult.Summary());
    }
}
