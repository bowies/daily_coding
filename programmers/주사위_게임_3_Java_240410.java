package programmers;

import java.util.Arrays;

class 주사위_게임_3_Java_240410 {
    public int solution(int a, int b, int c, int d) {

        //좋은 풀이!!!

        int[] dice = { a, b, c, d };
        Arrays.sort(dice);

        int answer = 0;

        if (dice[0] == dice[3]) {
            answer = 1111 * dice[3];
        } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
            answer = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
            answer = (dice[0] + dice[3]) * (dice[3] - dice[0]);
        } else if (dice[0] == dice[1]) {
            answer = dice[2] * dice[3];
        } else if (dice[1] == dice[2]) {
            answer = dice[0] * dice[3];
        } else if (dice[2] == dice[3]) {
            answer = dice[0] * dice[1];
        } else {
            answer = dice[0];
        }

        return answer;
    }
}