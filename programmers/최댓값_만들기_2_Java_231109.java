package programmers;

import java.util.Arrays;

class 최댓값_만들기_2_Java_231109 {
    /*
        정수 배열 numbers가 매개변수로 주어집니다.
        numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
        제한사항
            -10,000 ≤ numbers의 원소 ≤ 10,000
            2 ≤ numbers 의 길이 ≤ 100




     */
    public int solution_long(int[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;
        int max = numbers[length - 1] * numbers[length - 2];
        int min = numbers[0] * numbers[1];
        if (max > min) {
            return max;
        } else {
            return min;
        }
    }


    public int solution_short(int[] numbers) {
        int length = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[length - 2] * numbers[length - 1]);
    }
}