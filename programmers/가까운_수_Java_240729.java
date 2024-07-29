package programmers;

class 가까운_수_Java_240729 {

    public int solution(int[] array, int n) {
        int answer = array[0];

        for (int i : array) {
            if (Math.abs(n - i) < Math.abs(n - answer)) {
                answer = i;

            } else if (Math.abs(n - i) == Math.abs(n - answer) && i < answer) {
                answer = i;
            }
        }

        return answer;
    }
}