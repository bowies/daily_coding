package programmers;

class x만큼_간격이_있는_n개의_숫자_Java_240520 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        }
        return answer;
    }
}
