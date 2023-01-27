public class ParityDegree_230127 {
    public static void main(String[] args) {
        int N = 24;
        System.out.println(solution(N));
    }

    public static int solution(int N) {

        int answer = 0;

        while (N % 2 == 0) {
            N = N / 2;
            answer++;
        }

        return answer;
    }
}