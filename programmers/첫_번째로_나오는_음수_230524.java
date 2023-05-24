package programmers;

import java.util.stream.IntStream;

class Solution {
    public int solution1(int[] num_list) {
        return IntStream.range(0, num_list.length)
                .filter(i -> num_list[i] < 0)
                .findFirst()
                .orElse(-1);
    }

    public int solution2(int[] num_list) {
        int answer = -1;
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] < 0 ){
                answer = i;
                break;
            }
        }
        return answer;
    }
/*
    solution1 : 
    IntStream을 사용하여 num_list의 요소를 반복하고,
    각 요소가 0보다 작은지 확인하는 필터링 작업을 수행한다. 
    조건을 만족하는 첫 번째 인덱스를 찾은 후, 
    해당 인덱스를 반환하거나, 
    만족하는 인덱스가 없는 경우에는 -1을 반환한다.

    solution2 : 
    예로부터 내려오는 탐색을 한다.
*/




}
