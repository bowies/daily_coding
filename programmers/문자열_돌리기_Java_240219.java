package programmers;

import java.util.Scanner;

public class 문자열_돌리기_Java_240219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int length = str.length();

        for (int i = 0; i < length; i++) {
            System.out.println(str.charAt(i));
        }
    }

    public void mainTest(String input) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            System.out.println(input.charAt(i));
        }
    }
}
