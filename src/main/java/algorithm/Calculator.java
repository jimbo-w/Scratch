package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Arguments {
    public int arg1 = -1, arg2 = -1;

    public void addArg(int i) {
        if (arg1 == -1) arg1 = i;
        else if (arg2 == -1) arg2 = i;
        else throw new IllegalStateException("too many arguments");
    }
}

public class Calculator {

    private static final Set<Character> DIGITS = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));
    private static final Set<Character> OPERANDS = new HashSet<>(Arrays.asList('+', '*'));
    private static final Set<Character> PARENS = new HashSet<>(Arrays.asList('(', ')'));

    public static int calcString(String input) {
        Arguments args = new Arguments();
        char operand = '~';

        char[] cs = input.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            if (DIGITS.contains(c)) {
                args.addArg((Integer.valueOf(String.valueOf(c))));
            } else if (OPERANDS.contains(c)) {

                if(operand == '~') operand = c;
                else throw new IllegalStateException("too many OPERANDS");

            } else if (PARENS.contains(c)) {
                String remainder = input.substring(i, input.length());
                int closingParenIndex = closingParenIndex(remainder);
                int arg = calcString(remainder.substring(1, closingParenIndex));
                i = i + closingParenIndex;

                args.addArg(arg);
            }
        }

        if(args.arg2 == -1)
            return args.arg1;

        switch (operand) {
            case '+': return args.arg1 + args.arg2;
            case '*': return args.arg1 * args.arg2;
            default: throw new IllegalStateException("");
        }

    }

    private static int closingParenIndex(String substring) {
        int parenCount = 0;
        int closingParenIndex = 0;

        for(char c : substring.toCharArray()) {

            switch (c) {
                case '(': parenCount++; break;
                case ')': parenCount--; break;
            }

            if(parenCount == 0)
                return closingParenIndex;

            closingParenIndex++;

        }

        throw new IllegalStateException("mismatching parenthesis");
    }

    public static void main(String[] args) {

        assertThat(Calculator.calcString("(3)+(4*5)"), is(23));
        assertThat(Calculator.calcString("1+2"), is(3));
        assertThat(Calculator.calcString("(1+4)"), is(5));
        assertThat(Calculator.calcString("(1+2)+3"), is(6));
        assertThat(Calculator.calcString("(1+2)*3"), is(9));
        assertThat(Calculator.calcString("(2*(3+1))"), is(8));

    }
}
