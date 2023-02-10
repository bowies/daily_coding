package programmers;

import java.util.Arrays;

public class 주식가격_230210 {
    public static void main(String[] args) {
        int [] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }


    public static int[] solution(int[] prices) {
        //이거 스택 문제인데 다들 이렇게 푸는 재미있는 문제...

        int length = prices.length;
        int[] answer = new int[length];
        //초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
        //가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
        //[4, 3, 1, 1, 0]


        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //마지막 경우에는 그냥 0임 - 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
                answer[i]++;

                if (prices[i] > prices[j]){
                    break;
                }
            }
        }
        return answer;
    }
}
