package programmers;


import java.util.Scanner;

public class PCCE_기출문제_3번_수_나누기_Java_240907{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;
        
        while(number > 0){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}
