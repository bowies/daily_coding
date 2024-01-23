package programmers;

import java.util.Scanner;

class PCCE_기출문제_2번_피타고라스의_정리_Java_240122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = c*c - a*a;


        System.out.println(b_square);
    }
}