package programmers;
import java.util.*;

class 숫자_짝꿍_Greedy_Java_241017 { 
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        // 9부터 0까지 큰 숫자부터 확인하여 공통으로 있는 숫자를 추가
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < commonCount; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.toString().startsWith("0")) {
            return "0";
        }

        return answer.toString();
    }
}
