package programmers;

class 배열_조각하기_Java_240524 {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;

        for (int i = 0; i < query.length; i++) {
            int index = query[i];
            if (i % 2 == 0) {
                answer = arraySlicer(answer, 0, index + 1);
            } else {
                answer = arraySlicer(answer, index, answer.length);
            }
        }

        return answer;
    }

    private int[] arraySlicer(int[] arr, int start, int end) {
        int[] answer = new int[end - start];
        for (int i = start; i < end; i++) {
            answer[i - start] = arr[i];
        }
        return answer;
    }
}
