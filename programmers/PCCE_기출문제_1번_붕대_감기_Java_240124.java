package programmers;

import java.util.Scanner;

class PCCE_기출문제_1번_붕대_감기_Java_240124 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int 생명 = health;
        int index = 0;
        int 붕대감기 = 0;
        
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++){
            if (i != attacks[index][0]){
                생명 += bandage[1];
                붕대감기++;
                if (붕대감기 == bandage[0]){
                    생명 += bandage[2];
                    붕대감기 = 0;
                }
                if (생명 > health) 생명 = health;
            } else {
                붕대감기 = 0;
                생명 -= attacks[index][1];
                index++;
                if (생명 <= 0) return -1;
            }
        }
        return 생명;
    }
}