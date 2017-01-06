package bitmanipulation;

/**
 * Created by jimwang on 16/02/2016.
 */
public class BitFunctions {

    public static String decimalToBinary(double d) {

        if (d > 1 || d < 0) {
            return "ERROR";
        } else {
            StringBuilder s = new StringBuilder();
            s.append("0.");

            while (d > 0) {

                if (s.length() > 34) return "ERROR";
                else {
                    d = d * 2;

                    if (d >= 1) {
                        s.append("1");
                        d = d - 1;
                    } else {
                        s.append("0");
                    }
                }
            }

            return s.toString();
        }
    }

    public static int bitDiffs(int a, int b) {
        return countBits(a ^ b);
    }

    private static int countBits(int i) {
        int counter = 0;

        while (i > 0) {
            if ((i & 1) == 1) counter++;
            i >>= 1;
        }

        return counter;
    }
}
