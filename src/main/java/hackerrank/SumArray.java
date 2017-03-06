package hackerrank;

import java.util.*;

public class SumArray {

    public static int sumArray(List<Integer> n) {
        int sum = 0;
        for (Integer number : n) {
            sum = sum + number;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        List<Integer> array = new ArrayList<>();
        for(int i=0; i<size; i++) {
            array.add(scan.nextInt());
        }

        System.out.println(sumArray(array));
    }
}
