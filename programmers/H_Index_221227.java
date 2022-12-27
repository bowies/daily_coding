package programmers;

import java.util.Arrays;

public class H_Index_221227 {
    public static void main(String[] args) {
        int [] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        
        int answer = 0;
        int n = citations.length;
        int h = 0;

        int [] arr = citations.clone();
        Arrays.sort(arr);        
        

        for(int i = 0; i < n; i++){
            h = n - i; //논문 개수

            if(arr[i] >= h){
                //논문보다 인용수가 크거나 같으면 
                answer = h;
                break;
            }
        }

        return answer;
    }
    
}
