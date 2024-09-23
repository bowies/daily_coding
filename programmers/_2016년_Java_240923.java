package programmers;

class _2016년_Java_240923 {
    public String solution(int a, int b) {
        String[] daysOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // a월 전까지의 일수를 더함
        for (int i = 1; i < a; i++) {
            totalDays += daysInMonth[i];
        }
        
        // b일을 더함
        totalDays += b - 1; // 1월 1일 기준이므로 b-1일을 더함
        
        // 경과된 날 수를 7로 나눈 나머지를 이용해 요일 구하기
        return daysOfWeek[totalDays % 7];
    }
}
