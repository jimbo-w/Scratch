package concurrency.executor;

import java.util.Observable;

public class SomeObservable extends Observable implements Runnable{

    @Override
    public void run() {
        System.out.println("Running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        setChanged();
        notifyObservers();
    }

}
