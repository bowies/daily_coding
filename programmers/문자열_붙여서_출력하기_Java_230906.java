package programmers;

import java.util.Scanner;

public class 문자열_붙여서_출력하기_Java_230906 {
    /*
        두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
        입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String c = (a+b).trim();

        System.out.println(c);
    }
}