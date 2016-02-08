package concurrency.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Observer Pattern with thread pool
 *
 * Created by jim wang on 11/07/2015.
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        SomeObservable someObservable = new SomeObservable();

        int threads = 5;
        Executor executor = Executors.newFixedThreadPool(threads);

        for(int i=0; i<threads; i++){
            SomeObserver someObserver = new SomeObserver(i, executor);
            someObservable.addObserver(someObserver);
        }

        Thread one = new Thread(someObservable);
        one.run();
    }
}
