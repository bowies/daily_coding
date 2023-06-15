public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer++;
            while (answer % 3 == 0 || containsThree(answer)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean containsThree(int number) {
        String numberStr = String.valueOf(number);
        return numberStr.contains("3");
    }
}
