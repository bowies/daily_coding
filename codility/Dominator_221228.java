package codility;

import java.util.HashMap;

public class Dominator_221228 {
    public static void main(String[] args) {
        int [] A = {3,4,3,2,3,-1,3,3};
        System.out.println(solution(A));
    }
    public  static int solution(int[] A) {
        // Implement your solution here
        int answer = -1;

        //중복값이 배열 사이즈의 절반 이상 존재하면 그게 도미네이터임

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i : A){
            if(map.get(i) != null){
                //있으면
                map.put(i, (int)map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }

        for(Integer key : map.keySet()){
            if(map.get(key) > A.length/2){
                answer = key;
                break;
            }
        }

        for(int i = 0; i < A.length; i++){
            if(answer == A[i]){
                answer = i;
                break;
            }
        }


        return answer;
    }
}
