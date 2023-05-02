package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestResult testResult = new TestResult();
        new TestCaseTest("testTemplateMethod").run(testResult);
        new TestCaseTest("testResult").run(testResult);
        new TestCaseTest("testFaildResultFormatting").run(testResult);
        new TestCaseTest("testFailedResult").run(testResult);
        new TestCaseTest("testSuite").run(testResult);
        System.out.println(testResult.Summary());
    }
}
