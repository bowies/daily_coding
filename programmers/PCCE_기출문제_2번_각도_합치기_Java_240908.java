package programmers;

import java.util.Scanner;

public class PCCE_기출문제_2번_각도_합치기_Java_240908{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum_angle = angle1 + angle2;
        System.out.println(sum_angle%360);
    }
}