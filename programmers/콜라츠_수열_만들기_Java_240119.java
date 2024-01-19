package programmers;

import java.util.ArrayList;

class 콜라츠_수열_만들기_Java_240119 {
    public int[] solution(int n) {
        ArrayList<Integer> 콜라츠 = new ArrayList<>();
        콜라츠.add(n);

        while (n != 1) {
            if (n % 2 == 0) {
                // 짝수인 경우
                n /= 2;
            } else {
                // 홀수인 경우
                n = 3 * n + 1;
            }
            콜라츠.add(n);
        }

        // ArrayList를 int 배열로 변환
        int[] answer = new int[콜라츠.size()];
        for (int i = 0; i < 콜라츠.size(); i++) {
            answer[i] = 콜라츠.get(i);
        }

        return answer;
    }
}
