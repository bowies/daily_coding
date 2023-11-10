package programmers;
import java.util.Scanner;


public class 직각삼각형_출력하기_231110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //0번째 방식
        
        for(int i=1; i<=n; i++){
            System.out.println("*".repeat(i));
        }
        
        //1번째 방식
        for(int i = 0; i < n; i++){

            for(int j = 0; j <= i; j++){
                System.out.printf("*");

            }

            System.out.println("");


        }
    }
}