import java.util.Arrays;

public class NumberOfDiscIntersections_221223 {
    public static void main(String[] args) {
        int [] A = {1,5,2,1,4,0};
        int a = solution(A);
        System.out.println(a);
    }
    public static int solution(int[] A) {
        // Implement your solution here


        /*
         * 0 - 1
         * 1 - 5
         * 2 - 2
         * 3 - 1
         * 4 - 4
         * 5 - 0 //5는 없음
         * 
         * 
         */
  
        int len = A.length;
        long[] start = new long[len]; //앞 지점
        long[] end = new long[len]; //뒤 지점
        
        for(int i=0; i<len; i++){
            start[i] = i - (long)A[i]; //시작점 - 값
            end[i] = i + (long)A[i]; //시작점 + 값 
        }
        

        Arrays.sort(end); //정렬
        Arrays.sort(start); //정렬
        
        int answer = 0; //답 개수 
        int count=0;  //지점 couter
        
        for(int i = 0; i < len; i++){
            while( count < len && end[i] >= start[count]){
                    answer = answer + count; //교차하는 지점 추가 
                    answer = answer - i; //중복 제거용 i
                    count++;
            }          
        }
        
        if(answer > 10000000){
            return -1;
        } //overFlow 계산해야 한다고 함 (오류!)
        
        return answer; 
    }
}
