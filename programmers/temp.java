package programmers;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        /*
        
        문자열 str과 정수 n이 주어집니다.
        str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
        */

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
    public static void main2(String[] args) {
        /*

        문자열 str과 정수 n이 주어집니다.
        str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
        */

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        System.out.println(str.repeat(n));
    }
}