package codility;

public class PassingCars_221216 {
    
    public static void main(String[] args) {
        int [] A = {0,1,0,1,1};
        solution(A);
    }
    public static int solution(int[] A) {
        //0 : 동쪽으로 이동 >>
        //1 : 서쪽으로 이동 <<

        int answer = 0;
        int temp = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                temp++;
            }else{
                //if 1 -> pair
                answer += temp;
            }
        }

        if (answer > 1000000000 || answer < 0){
            return -1;
        } 
            return answer;
    }
}
