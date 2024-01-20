package programmers;

class 가장_큰_수_찾기_Java_240120 {
    public int[] solution(int[] array) {
        int temp = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
                index = i;
            }
        }

        int[] answer = {temp, index};
        return answer;
    }
}
