package programmers;

import java.util.Scanner;

public class 대소문자_바꿔서_출력하기_Java_240417 {
    //VPN upload
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String 문자열 = sc.next();

        StringBuilder answer = new StringBuilder();

        for (char chr : 문자열.toCharArray()) {
            if (Character.isUpperCase(chr)) {
                answer.append(Character.toLowerCase(chr));
            } else {
                answer.append(Character.toUpperCase(chr));
            }
        }
        System.out.println(answer.toString());
    }
}
