package designpattern;

/**
 * Not thread-safe
 */
public class Singleton {

    private static Singleton instance;

    // Need to override default public constructor
    //
    private Singleton() {}

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}
