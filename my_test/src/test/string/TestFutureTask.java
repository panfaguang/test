package test.string;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestFutureTask extends FutureTask implements Comparable {
    public TestFutureTask(Callable callable) {
        super(callable);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
