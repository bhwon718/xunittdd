package xunit;

public class TestReslt {

    int runCount = 0;

    public void testStarted() {
        runCount++;
    }

    public String Summary() {
        return runCount + " run, 0 failed";
    }
}
