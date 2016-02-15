package designpattern;

//import static designpattern.NumberFactory.NumberType.*;

public class NumberFactory {
    enum NumberType {
        INT, DOUBLE
    }

    public static Number createNumber(NumberType type) {

        switch(type) {
            case INT: return 0;
            case DOUBLE: return (double) 0;
            default: throw new IllegalArgumentException(String.format("Unrecognised NumberType: %s", type.name()));
        }
    }

}
