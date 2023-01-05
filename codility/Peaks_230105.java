package codility;

import java.util.ArrayList;
import java.util.List;

public class Peaks_230105 {
    public static void main(String[] args) {
        int [] A = {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));
    }

    
    public static int solution(int[] A) {
        
        int len = A.length;

        if(len < 3){
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i< len-1; i++){
            if( A[i-1] < A[i] && A[i] > A[i+1] ){
                //피크 찾기
                list.add(i);
            }
        }
        
        
        for(int i =len; i >=1; i--){
                    
            if( len % i ==0){   
            
                int length = len / i; 
                int counter = 0;  

                for(int j : list){
                    if( j / length == counter){ 
                        //i번째 블록 피크를 찾음
                        counter++; //counter 증가시킴
                    }
                }   
                
                if(counter == i){
                    //피크 있을 때만 여기서 반환함
                    return i;
                }
            }
        }   
        
        return 0;
    }
}
