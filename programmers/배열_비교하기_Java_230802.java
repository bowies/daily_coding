package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

class 배열_비교하기_Java_230802 {
    /*
    이 문제에서 두 정수 배열의 대소관계를 다음과 같이 정의합니다.

    두 배열의 길이가 다르다면, 배열의 길이가 긴 쪽이 더 큽니다.
    배열의 길이가 같다면 각 배열에 있는 모든 원소의 합을 비교하여 다르다면 더 큰 쪽이 크고, 같다면 같습니다.
    두 정수 배열 arr1과 arr2가 주어질 때,
    위에서 정의한 배열의 대소관계에 대하여
    arr2가 크다면 -1,
    arr1이 크다면 1,
    두 배열이 같다면 0을 return 하는 solution 함수를 작성해 주세요.
     */

    public int solution(int[] arr1, int[] arr2) {
        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();

        if (arr1.length != arr2.length) {
            //배열 길이 다르면 긴 쪽이 더 큼
            return Integer.compare(arr1.length, arr2.length);
        } else {
            return Integer.compare(sum1, sum2);
        }
    }


    public int solution2(int[] arr1, int[] arr2) {
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }
}