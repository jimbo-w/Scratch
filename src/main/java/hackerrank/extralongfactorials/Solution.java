package hackerrank.extralongfactorials;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        System.out.println(factorial(n));
    }

    static BigInteger factorial(int n) {
        if(n == 0) {
            return BigInteger.ONE;
        }
        else {
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
}
