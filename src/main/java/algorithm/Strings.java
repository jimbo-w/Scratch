package algorithm;

public class Strings {

    public static void replaceSpaces(char[] s, int l) {

        for(int i = 0; i < s.length; i++) {

            if(s[i] == ' ') {

                for(int j = s.length-1; j > i + 2; j--) {
                    s[j] = s[j-2];
                }

                s[i] = '%';
                s[i+1] = '2';
                s[i+2] = '0';

            }
        }
    }
}
