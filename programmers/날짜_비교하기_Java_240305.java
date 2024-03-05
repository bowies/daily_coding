package programmers;

class 날짜_비교하기_Java_240305 {
    public int solution(int[] date1, int[] date2) {
        for (int i = 0; i < 3; i++) {
            if (date1[i] < date2[i]) {
                return 1;
            } else if (date1[i] > date2[i]) {
                return 0;
            }
        }
        return 0;
    }
    public int solution_2(int[] date1, int[] date2) {
        for (int i = 0; i < 3; i++) {
            int answer = Integer.compare(date1[i], date2[i]);
            if (answer != 0) {
                return answer < 0 ? 1 : 0;
            }
        }
        return 0;
    }
}
