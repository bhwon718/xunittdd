package xunit;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {
    List<Test> tests = new ArrayList<>();

    public TestSuite(Class<? extends TestCase> testClass) {
        Arrays.stream(testClass.getMethods()).filter(m-> m.getName().startsWith("test"))
                .forEach( m ->
                        {
                            try {
                                add(testClass.getConstructor(String.class).newInstance(m.getName()));
                            } catch (Exception e) {
                                throw new RuntimeException(e);

                            }
                        }
                );
    }

    public TestSuite() {

    }

    public void add(Test test) {
        tests.add(test);
    }

    public TestResult run(TestResult testResult) {
        tests.forEach(t->{
            t.run(testResult);
        });
        return testResult;
    }
}
