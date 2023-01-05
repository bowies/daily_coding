package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 연속부분수열합의개수_230105 {
    public static void main(String[] args) {
        int [] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }

    
    public static int solution(int[] elements) {
        //철호는 수열을 가지고 놀기 좋아한다...
        //철호는 원형 수열을 만드는 것을 조아한다... ^^
        //연속 부분 수열 합으로 만들 수 있는 수의 개수를...만들어달라

        int answer = 0;
        int [] arr = new int [elements.length * 2];

        for(int i = 0; i < elements.length; i++){
            /*
            arr[i] = elements[i];
            arr[i+elements.length] = elements[i];
            //최종값을 <<랑 <에 넣음
            */
            arr[i] = arr[i+elements.length] = elements[i];
            
        }
        


        HashSet set = new HashSet<>();

        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                set.add(Arrays.stream(arr, j, j+i).sum());
            }
        }

        answer = set.size();
        return answer;
    }
}
