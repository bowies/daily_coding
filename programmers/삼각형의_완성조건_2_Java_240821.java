package programmers;

class 삼각형의_완성조건_2_Java_240821 {
    public int solution(int[] sides) {
        int big = Math.max(sides[0], sides[1]);
        int small = Math.min(sides[0], sides[1]);

        int min = big - small;
        int max = big + small;

        return max - min - 1;
    }
    
    public int solution_best(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        answer += min * 2 - 1;

        return answer;
    }
}
