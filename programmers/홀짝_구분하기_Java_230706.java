package programmers;

import java.util.Scanner;

public class 홀짝_구분하기_Java_230706 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2 == 0){
            System.out.println(n+"is even");
        }else{
            System.out.println(n+"is odd");
        }
    }

    public static void 삼항연산자(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n+ " is " + (n%2 == 0 ? "even" : "odd"));
    }

}
