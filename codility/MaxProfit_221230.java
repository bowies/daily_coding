package codility;

public class MaxProfit_221230 {
    public static void main(String[] args) {
        int [] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
          
        int answer = 0;

        int temp = 0;
        int min = 400000;
        int max = 0;        
        
        for(int i = 0; i < A.length; i++){            
            
            if(A[i] < min){
                min = A[i];
                max = A[i];
            }else if(A[i] > max){
                max = A[i];
            }
        
            temp = max - min;
            
            if(temp > answer){
                //마이너스 값 체크용
                answer = temp;
            }
        }
        return answer;
    }
}
