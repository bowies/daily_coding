package programmers;

import java.util.Scanner;

class PCCE_기출문제_3번_아날로그_시계_Java_240125.java {
    
    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        return 시계돌리기(h2, m2, s2) - 시계돌리기(h1, m1, s1) + ((s1 == 0 && m1 == 0) ? 1 : 0);
    }

    private static int 시계돌리기(int h, int m, int s) {
        int 분세기 = 0;
        int 시세기 = 0;

        분세기 += h * 59;
        시세기 += h * 60;

        int result = 0;

        분세기 += m;
        시세기 += m;
        result -= 1;

        double curMDegree = m * 6;
        double curHDegree = 30 * (h % 12) + 0.5 * m;
        boolean condition1 = curMDegree <= 5.9 * s;
        boolean condition2 = curHDegree <= (6 - 1 / 120.0) * s;

        if (condition1) 분세기 += 1;
        if (condition2) 시세기 += 1;

        if (h >= 12) {
            시세기 -= 1;
            result -= 1;
        }

        result += 분세기 + 시세기;

        return result;
    }

}