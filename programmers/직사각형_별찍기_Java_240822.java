package programmers;

import java.util.Scanner;
import java.util.stream.IntStream;

class 직사각형_별찍기_Java_240822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                System.out.print("*");  
            }
            System.out.println("");  
        
        }
    }


    public static void main_better() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        StringBuilder row = new StringBuilder();
        for (int j = 0; j < n; j++) {
            row.append("*");
        }

        for (int i = 0; i < m; i++) {
            System.out.println(row.toString());
        }
    }

    public static void main_best() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
    }
}

