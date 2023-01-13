import java.util.Arrays;

public class NailingPlanks_230112 {
    public static void main(String[] args) {
        NailingPlanks_230112 n = new NailingPlanks_230112();
        int [] A = {1,4,5,8};
        int [] B = {4,5,9,10};
        int [] C = {4,6,7,10,2};
        System.out.println(n.solution(A, B, C));
    }
    
    public int solution(int[] A, int[] B, int[] C) {
        //A 랑 B는 N개의 널빤지
        //A[K]는 시작이고, B[K]는 K번째 널빤지의 끝
        //비어 있지 않은 배열 C 
        //는 M 못을 나타냄 -> C[i] 는 i번째 못을 박을 수 있는 위치
        //A[k] <= C[i] <= B[k]에 C[i]가 있으면 못박혔다고 함
        //최소 못을 찾아야 한다고 함
        
        int[][] 못 = new int[C.length][2];
        //못 위치 저장용        
        for (int i = 0; i < C.length; i++) {
            못[i][0] = C[i];
            못[i][1] = i;
        }

        Arrays.sort(못, (int 못1[], int 못2[]) -> 못1[0] - 못2[0]); //정렬 필요함

    /*
        for(int [] i : 못){
            System.out.println(Arrays.toString(i));
        }

            [2, 4]
            [4, 0]
            [6, 1]
            [7, 2]
            [10, 3]
            이렇게 정렬해줌 
            역순으로 10,3 7,2 이렇게 하려면 못2 - 못1 하면 됨!
            그냥 못 실제 위치랑 index랑 정렬해 놓는 코드임
         */

        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            //못 박을 수 있는 위치 찾기
            temp = 위치찾기(A[i], B[i], 못, temp);
            if (temp == -1){
                return -1;
            }
        }

        return temp + 1; 
    }
    

    public int 위치찾기(int A, int B, int[][] 못, int temp) {

        int 최소 = 0;
        int 최대 = 못.length - 1;

        int 위치값 = -1;
        while (최소 <= 최대) {
            int mid = (최소 + 최대) / 2;
            if (못[mid][0] < A){
                최소 = mid + 1;                
            }
            else if (못[mid][0] > B){
                최대 = mid - 1;
            }
            else {
                최대 = mid - 1;
                위치값 = mid;
            }
        }
        if (위치값 == -1){
            //아예 값 안에 없으면 이별함
            return -1;
        }

        int answer = 못[위치값][1]; //못 진짜 위치임
        for (int i = 위치값; i < 못.length; i++) {
            if (못[i][0] > B){
                break;
            }
            answer = Math.min(answer, 못[i][1]);
            //temp에서 받아온 애보다 작으면 도로 temp 줌
            if (answer <= temp){
                return temp;
            }            
        }
        return answer;
    }
}
