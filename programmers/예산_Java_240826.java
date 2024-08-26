package programmers;
import java.util.Arrays;

class 예산_Java_240826 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for (int cost : d) {
            if (budget - cost >= 0) {  // 예산이 충분하면
                budget -= cost;        // 예산에서 해당 금액 차감
                answer++;              // 지원한 부서 수 증가
            } else {
                break;  // 예산이 부족해지면 중단
            }
        }
        
        return answer;
    }
}
