package io.github.ifanzero.method;

public class RomanToInt_13_S {
    public static int romanToInt(String s) {

        int length = s.length();
        int sum = 0;
        int j;
        for (int i = length - 1; i >= 0; i--) {
            j = i - 1;
            if (s.charAt(i) == 'I') {
                sum += 1;
            } else if (s.charAt(i) == 'X') {
                if (j >= 0 && s.charAt(j) == 'I') {
                    sum += 9;
                    i--;
                } else {
                    sum += 10;
                }
            } else if (s.charAt(i) == 'C') {
                if (j >= 0 && s.charAt(j) == 'X') {
                    sum += 90;
                    i--;
                } else {
                    sum += 100;
                }
            } else if (s.charAt(i) == 'M') {
                if (j >= 0 && s.charAt(j) == 'C') {
                    sum += 900;
                    i--;
                } else {
                    sum += 1000;
                }
            } else if (s.charAt(i) == 'V') {
                if (j >= 0 && s.charAt(j) == 'I') {
                    sum += 4;
                    i--;
                } else {
                    sum += 5;
                }

            } else if (s.charAt(i) == 'L') {
                if (j >= 0 && s.charAt(j) == 'X') {
                    sum += 40;
                    i--;
                } else {
                    sum += 50;
                }
            } else if (s.charAt(i) == 'D') {
                if (j >= 0 && s.charAt(j) == 'C') {
                    sum += 400;
                    i--;
                } else {
                    sum += 500;
                }

            }

        }
        return sum;
    }
}
