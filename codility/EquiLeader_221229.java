package codility;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader_221229 {
    public static void main(String[] args) {
        int [] A = {4,3,4,4,4,2};
        System.out.println(solution(A));
    }
    
    public static int solution(int[] A) {
        int answer = 0;
        int leader = 0;   
        int temp = 0;      
        int [] counter = {0, 0, 0, 0, 0};
        //map 키값용 , map 최대값용, 리더 확인용 카운터, 반 자르기용 카운터, 최대값용

        if(A.length == 0){
            answer = 0;
            return answer;
        }

        Map <Integer, Integer> map = new HashMap<>();
        
        for(int i : A){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        counter[1] = 1; //초기값 설정

        for(int i : map.keySet()){
            counter[0] = map.get(i);
            if(counter[0] > counter[1]){
                counter[1] = counter[0];
                counter[4] = i;
            }
        }


        if(counter[1] > A.length/2){
            leader = counter[4];
            counter[2] = counter[1];
        }else{
            answer = 0;
            return 0;
        }


        for(int i=0; i<A.length; i++){
            
            if(A[i] == leader){
                counter[3] = counter[3] + 1;
            }
            
            if( counter[3] > (i+1)/2 ){ 
                temp = counter[2] - counter[3];          
                if( temp > (A.length -i -1)/2 ){
                    answer++;
                }
            } 
        }



        return answer;
    }
}
