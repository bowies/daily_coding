import java.util.Arrays;

public class SlalomSkiing_230124{
    public static void main(String[] args) {
        int [] A = {15,13,5,7,4,10,12,8,2,11,6,9,3};
        System.out.println(solution(A));
    }   
    
    
    public static int solution(int[] A) {
        long 최대값 = Arrays.stream(A).max().getAsInt();

        long [] 방향바꾸기용 = new long[A.length*3];

        
        for(int i = 0; i < A.length; i++){
            방향바꾸기용[i*3] = 최대값 * 2 + A[i] + 1;
            방향바꾸기용[i*3+1] = 최대값 * 2 - A[i] + 1;
            방향바꾸기용[i*3+2] = A[i];
        }  

        /*
        for(long l : 방향바꾸기용){
            System.out.println("\t" + l);
        }

                46
                16
                15

                44
                18
                13

                36
                26
                5

                38
                24
                7

                35
                27
                4

                41
                21
                10

                43
                19
                12
                
                39
                23
                8

                33
                29
                2

                42
                20
                11

                37
                25
                6

                40
                22
                9

                34
                28
                3
        */

        int answer = 경로찾기(방향바꾸기용);

        return answer;
    }

    public static int 경로찾기(long [] A) {
        long[] arr = new long[A.length];

        int answer = 0;

        for(int i = 0; i < A.length; i++){
            int temp = Arrays.binarySearch(arr, 0, answer, A[i]); //이진탐색으로 안 하면 효율성에 걸림
            
            if(temp < 0){
                temp = -temp-1;
            }

            if(temp == answer){
                answer++;
            }

            arr[temp] = A[i];
        }
        return answer;
    }
}