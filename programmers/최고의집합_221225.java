package programmers;

import java.util.Arrays;

public class 최고의집합_221225 {
    public static void main(String[] args) {
        int n = 2;
        int s = 9;
        solution(n, s);
    }
    public static int[] solution(int n, int s) {
        //중간쯤 값이 곱했을때 제일 큼

        int [] answer = new int[n];

        if( n > s ){
            return new int [] {-1};
        }else{
            
            int div = s/n; // 9 /2
            int rem = s%n; //9 % 2

            for(int i = 0; i < n; i++){
                if(i >= (n-rem)){
                    answer[i] = div+1;
                }else{
                    answer[i] = div;
                }
            }
        }
        Arrays.sort(answer);
        return answer;

    }
}
 