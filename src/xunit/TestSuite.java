package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    List<WasRun> wasRunList = new ArrayList<>();
    public void add(WasRun testMethod) {
        wasRunList.add(testMethod);
    }

    public TestResult run(TestResult testResult) {
        wasRunList.forEach(t->{
            t.run(testResult);
        });
        return testResult;
    }
}
