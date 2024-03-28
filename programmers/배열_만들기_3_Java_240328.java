package programmers;

class 배열_만들기_3_Java_240328 {
    public int[] solution(int[] arr, int[][] intervals) {

        int length = intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2;
        
        int[] answer = new int[length];
        
        int current = 0;

        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            answer[current++] = arr[i];
        }
        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            answer[current++] = arr[i];
        }
        
        return answer;
    }



    public int[] solution_similar(int[] arr, int[][] intervals) {

        int s1 = intervals[0][0], e1 = intervals[0][1], s2 = intervals[1][0], e2 = intervals[1][1], idx = 0;
        int[] answer = new int[e1 - s1 + e2 - s2 + 2];

        for (int i = s1; i <= e1; i++) {
            answer[idx++] = arr[i];
        }

        for (int i = s2; i <= e2; i++) {
            answer[idx++] = arr[i];
        }

        return answer;
    }
}
