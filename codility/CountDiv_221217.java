package codility;

public class CountDiv_221217 {
    
    public static void main(String[] args) {
        int A = 6;
        int B = 11;
        int K = 2;
        solution(A, B, K);
    }
    public static int solution(int A, int B, int K) {

        int answer = 0;
        /*
        for(int i = A; i <= B; i++){
            if(i%K==0){
                answer++;
            }
        }
         */
        //이렇게 짜겠지만 시간 복잡도 생각하면
        answer = B/K - A/K; // 나눠지는 거 계산하는 거 자체가 0~B까진데 0~A까지 뺴주면 됨
        if(A % K == 0){
            answer++; //A가 같이 나눠지면 추가해줘야 함
        }
        
        return answer;
    }
}