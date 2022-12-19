package programmers;

import java.util.Arrays;

public class 구명보트_221219 {
    public static void main(String[] args) {
        int [] people = {70, 50, 80, 50};
        int limit = 100;

        solution(people, limit);
    }

    public static int solution(int[] people, int limit) {
        if(people.length==1){
            //1명이면 무조건 1번
            return 1;
        }

        int answer = 0;
        int j = 0; //몸무게 제일 적은 사람 counter
        
        Arrays.sort(people);
        /*
        for(int i : people){
            System.out.println(i);
        }
        */

        for(int i = people.length-1; i >= j; i--){
            if(people[i] + people[j] > limit){
                //제일 적은 사람 + 제일 무거운 사람 -> limit 보다 크면 무거운 사람을 빨리 처리하려는 목적 
                answer++;
            }else{
                //이거는 둘의 합이 limit 보다 작거나 같은 경우라 둘다 ㄱㄱ
                j++;
                answer++;
            }
        }
        return answer;
    }
}
