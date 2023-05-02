package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run();
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    public void testResult(){
        WasRun wasRun = new WasRun("testMethod");
        TestReslt testResult = wasRun.run();
        Assert.assertEquals("1 run, 0 failed", testResult.Summary());
    }
}
