package concurrency.executor;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;

public class SomeObserver implements Observer {
    private int workerId;
    private final Executor executor;

    public SomeObserver(int workerId, Executor executor) {
        this.workerId = workerId;
        this.executor = executor;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.printf("Worker [%s] Notified, doing something else\n", workerId);

        executor.execute(() -> {
            System.out.printf("Worker [%s] Running\n", workerId);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.printf("Worker [%s] Interrupted\n", workerId);
            }
        });
        System.out.printf("Worker [%s] Done\n", workerId);
    }
}
