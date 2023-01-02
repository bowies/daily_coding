package programmers;

public class CountFactors_230102 {
    public static void main(String[] args) {
        int N = 24;
        System.out.println(solution(N));
    }
    
    public static int solution(int N) {
     
        int answer = 0;
        long i = 1;
        
        while(i * i < N){
            if(N % i == 0){
                answer++;
            }
            i++;
        }
        answer = answer*2;
        if(i * i == N){
            answer++;
        }
        
        return answer;
    }
}
