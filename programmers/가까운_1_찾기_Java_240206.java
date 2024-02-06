package programmers;

import java.util.stream.IntStream;

class 가까운_1_찾기_Java_240206 {

    public int solution(int[] arr, int idx) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == 1 && idx <= i)
                .findFirst()
                .orElse(-1);
    }
    public int solution_non(int[] arr, int idx) {
        int answer = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1 && idx <= i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}