package programmers;

import java.util.Arrays;

class 없는_숫자_더하기_Java_230809 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] found = new boolean[10]; // 0부터 9까지의 숫자가 있는지 여부를 저장하는 배열

        Arrays.sort(numbers);

        // 주어진 배열의 숫자들을 확인하여 해당 숫자를 찾았음을 표시
        for (int num : numbers) {
            found[num] = true;
        }

        // 0부터 9까지의 숫자 중에서 찾을 수 없는 숫자들을 더함
        for (int i = 0; i < 10; i++) {
            if (!found[i]) {
                answer += i;
            }
        }

        return answer;
    }


    //사실 이거 2나 3 방향으로 푸는 게 맞다!!!! 효율!!


    public int solution2(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }


    public int solution3(int[] numbers) {
        return 45-Arrays.stream(numbers).sum();
    }

}
