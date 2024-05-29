package programmers;

class 연속된_부분_수열의_합_Java_240529 {
    public int[] solution(int[] sequence, int k) {

        int 시작 = 0, 끝 = 0, 현재합 = 0;
        int 최소길이 = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (끝 < sequence.length) {
            현재합 += sequence[끝];
            
            while (현재합 > k && 시작 <= 끝) {
                현재합 -= sequence[시작];
                시작++;
            }
            
            if (현재합 == k) {
                int 현재길이 = 끝 - 시작 + 1;
                if (현재길이 < 최소길이) {
                    최소길이 = 현재길이;
                    answer[0] = 시작;
                    answer[1] = 끝;
                }
            }
            끝++;
        }
        
        return answer;
    }
}
