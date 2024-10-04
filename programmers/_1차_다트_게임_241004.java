package programmers;

import java.util.ArrayList;

class _1차_다트_게임_241004 {
    public int solution(String dartResult) {
        int 총점 = 0;
        ArrayList<Integer> 점수목록 = new ArrayList<>();
        int 길이 = dartResult.length();
        int 인덱스 = 0;

        while (인덱스 < 길이) {
            int 점수 = 0;
            if (dartResult.charAt(인덱스) == '1' && 인덱스 + 1 < 길이 && dartResult.charAt(인덱스 + 1) == '0') {
                점수 = 10;
                인덱스 += 2;
            } else {
                점수 = dartResult.charAt(인덱스) - '0';
                인덱스++;
            }

            char 보너스 = dartResult.charAt(인덱스);
            인덱스++;
            if (보너스 == 'S') {
                점수 = (int) Math.pow(점수, 1);
            } else if (보너스 == 'D') {
                점수 = (int) Math.pow(점수, 2);
            } else if (보너스 == 'T') {
                점수 = (int) Math.pow(점수, 3);
            }

            if (인덱스 < 길이 && (dartResult.charAt(인덱스) == '*' || dartResult.charAt(인덱스) == '#')) {
                char 옵션 = dartResult.charAt(인덱스);
                인덱스++;
                if (옵션 == '*') {
                    점수 *= 2;
                    if (!점수목록.isEmpty()) {
                        점수목록.set(점수목록.size() - 1, 점수목록.get(점수목록.size() - 1) * 2);
                    }
                } else if (옵션 == '#') {
                    점수 *= -1;
                }
            }

            점수목록.add(점수);
        }

        for (int 점수 : 점수목록) {
            총점 += 점수;
        }

        return 총점;
    }
}
